package com.example.affirmations.ui

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.affirmations.model.Affirmation
import com.example.affirmations.ui.theme.AffirmationsTheme

class MainScreen {
    @Composable
    fun AffirmationApp(affirmationList: List<Affirmation>, onMoreDetails : (id: Int) -> Unit) {
        // TODO 4. Apply Theme and affirmation list
        AffirmationsTheme {
            AffirmationList(affirmationList = affirmationList,onMoreDetails)
        }
    }

    @Composable
    fun AffirmationList(affirmationList: List<Affirmation>, onMoreDetails: (id: Int) -> Unit) {
        // TODO 3. Wrap affirmation card in a lazy column
        LazyColumn{
            items(affirmationList){affirmation -> AffirmationCard(affirmation, onMoreDetails = onMoreDetails)}
        }
    }

    @Composable
    fun AffirmationCard(affirmation: Affirmation, modifier: Modifier = Modifier, onMoreDetails: (id: Int) -> Unit) {
        // TODO 1. Your card UI
        val color by animateColorAsState(targetValue = MaterialTheme.colors.surface)
        var expanded by remember{ mutableStateOf(false) }
        Card(
            Modifier
                .padding(10.dp)
                .fillMaxSize()
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
                .background(
                    color = color
                )) {

            Row {

                Image(
                    painter = painterResource(id = affirmation.imageResourceId),
                    contentDescription = "ImageRow",
                    modifier = Modifier.padding(top = 10.dp),
                )
                Text(
                    text = stringResource(id = affirmation.stringResourceId),
                    modifier = Modifier.padding(top = 25.dp, start = 10.dp)
                )
            }
            Column(horizontalAlignment = Alignment.End, modifier = modifier.padding(top = 50.dp)) {

                IconButton(onClick = { expanded = !expanded }) {
                    Icon(
                        imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                        tint = MaterialTheme.colors.secondary,
                        contentDescription = "A."
                    )
                }
            }
            if (expanded) {
                AffirmationCardDescription(affirmation = affirmation, onMoreDetails = onMoreDetails)
            }
        }
    }
    @Composable
    private  fun AffirmationCardDescription(affirmation: Affirmation, onMoreDetails : (id: Int) -> Unit){
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(top = 100.dp)) {
            Text(text = stringResource(id = affirmation.titleDescriptionId),)
            Text(text = stringResource(id = affirmation.descriptionResourceId),overflow = TextOverflow.Ellipsis,
                maxLines = 2)
            TextButton(onClick = {onMoreDetails(affirmation.Id)}) {
                Text( text = "See more...")
            }
        }
    }
}
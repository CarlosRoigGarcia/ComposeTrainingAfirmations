/*
 * Copyright (C) 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.affirmations

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.affirmations.data.Datasource
import com.example.affirmations.model.Affirmation
import com.example.affirmations.ui.theme.AffirmationsTheme


private const val Tag = "main act"
private const val TagResume = "resume act"
private const val TagRestart = "restart act"
private const val TagPause = "pause act"
private const val TagDestroy = "destroy act"
private const val TagStop = "stop act"
private const val TagStart = "start act"
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                AffirmationApp()
            // TODO 5. Show screen
            Log.d(Tag, "onCreate")
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TagStart, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TagResume, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TagPause, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TagStop, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TagDestroy, "onDestroy")
    }
    override fun onRestart() {
        super.onRestart()
        Log.d(TagRestart, "onRestart")
    }
}

@Composable
fun AffirmationApp() {
    // TODO 4. Apply Theme and affirmation list
    AffirmationsTheme {
        val count = rememberSaveable{
            mutableStateOf(0)
        }
        Column() {
            TextButton(onClick = { count.value += 1 }) {
                Text(text = "Pulsado ;)   ${count.value}")
            }
            AffirmationList(affirmationList = Datasource().loadAffirmations())
        }
    }
}

@Composable
fun AffirmationList(affirmationList: List<Affirmation>) {
    // TODO 3. Wrap affirmation card in a lazy column
    LazyColumn{
        items(affirmationList){affirmation -> AffirmationCard(affirmation)}
    }
}

@Composable
fun AffirmationCard(affirmation: Affirmation, modifier: Modifier = Modifier) {
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
                AffirmationCardDescription(affirmation = affirmation)
            }
    }
}
@Composable
private  fun AffirmationCardDescription(affirmation: Affirmation){
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(top = 100.dp)) {
        Text(text = stringResource(id = affirmation.titleDescriptionId))
        Row() {
            Text(text = stringResource(id = affirmation.descriptionResourceId),overflow = TextOverflow.Ellipsis,
                maxLines = 2)
            TextButton(onClick = { /*TODO*/ }) {
            }
        }

    }
}

@Preview
@Composable
private fun AffirmationCardPreview() {
    // TODO 2. Preview your card
//AffirmationCard(affirmation =  Affirmation(R.string.affirmation1, R.drawable.image1,R.string.affirmation1,R.string.affirmation2))
}





package com.example.affirmations.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.affirmations.model.Affirmation

class DetailScreen {
    @Composable
    fun DetailLayout(affirmation: Affirmation, onPhoneTouch: () -> Unit, onEmailTouch: () -> Unit)
    {
        Column(
            Modifier
                .padding(start = 20.dp)
                .fillMaxSize()
        ) {
            Row(Modifier.padding(top = 50.dp, bottom = 20.dp)) {
                Image(
                    painter = painterResource(id = affirmation.imageResourceId),
                    contentDescription = "DetailImage",
                    alignment = Alignment.Center
                )
            }
            Row(Modifier.padding(bottom = 15.dp, start = 35.dp)) {
                Text(text = stringResource(id = affirmation.stringResourceId))
            }
            Row(Modifier.padding(bottom = 15.dp)) {
                Text(
                    text = stringResource(id = affirmation.descriptionResourceId),
                    Modifier.padding(bottom = 15.dp)
                )
            }
            Row {
                IconButton(onClick = { onPhoneTouch() }) {
                    Icon(
                        imageVector = Icons.Filled.Phone,
                        contentDescription = "Phone Number",
                        Modifier.padding(end = 15.dp)
                    )
                }
                IconButton(onClick = { onEmailTouch() }) {
                    Icon(
                        imageVector = Icons.Filled.Email,
                        contentDescription = "EmailMessage",
                        Modifier.padding(end = 15.dp)
                    )
                }
            }
        }
    }
}
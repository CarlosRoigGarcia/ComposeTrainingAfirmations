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
package com.example.affirmations.ui

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
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
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.affirmations.data.Datasource
import com.example.affirmations.model.Affirmation
import com.example.affirmations.ui.theme.AffirmationsTheme
import com.example.affirmations.ui.viewmodel.DetailViewModel
import com.example.affirmations.ui.viewmodel.MainViewModel


/*private const val Tag = "main act"
private const val TagResume = "resume act"
private const val TagRestart = "restart act"
private const val TagPause = "pause act"
private const val TagDestroy = "destroy act"
private const val TagStop = "stop act"
private const val TagStart = "start act"*/
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val mainViewModel: MainViewModel = viewModel()
            val mainUiState by mainViewModel.uiState.collectAsState()
            MainScreen().AffirmationApp(affirmationList = mainUiState.affirmations, onMoreDetails = {startDetailActivity(it)})
            // TODO 5. Show screen
           // Log.d(Tag, "onCreate")
        }
    }

    private fun startDetailActivity(id : Int){
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("Id", id)
        startActivity(intent)
    }
}




@Preview
@Composable
private fun AffirmationCardPreview() {
    // TODO 2. Preview your card
//AffirmationCard(affirmation =  Affirmation(R.string.affirmation1, R.drawable.image1,R.string.affirmation1,R.string.affirmation2))
}


/* override fun onStart() {
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
 }*/

package com.example.affirmations.ui


import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.affirmations.ui.viewmodel.DetailViewModel

class DetailActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val id = intent.getIntExtra("Id", 1)
        setContent {
            val detailViewModel: DetailViewModel = viewModel()
            detailViewModel.setDescriptionValuesById(id)
            val detailUiState by detailViewModel.uiState.collectAsState()
            val email = stringResource(id = detailUiState.affirmation.emailResourceId)
            val subject = stringResource(id = detailUiState.affirmation.titleDescriptionId)
            val phoneNumber = stringResource(id = detailUiState.affirmation.phoneResourceId)
            DetailScreen().DetailLayout(
                affirmation = detailUiState.affirmation,
                onEmailTouch = { sendMail(email, subject) },
                onPhoneTouch = { dial(phoneNumber) })
        }
    }
     private fun Context.sendMail(to: String, subject: String) {
        try {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "message/rfc822"
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(to))
            intent.putExtra(Intent.EXTRA_SUBJECT, subject)
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
                error("No email app is available")
        } catch (t: Throwable) {
            error("Error: General Error")
        }
    }

     private fun Context.dial(phone: String) {
        try {
            val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))
            startActivity(intent)
        } catch (t: Throwable) {
            error("Error: General Error")
        }
    }
}
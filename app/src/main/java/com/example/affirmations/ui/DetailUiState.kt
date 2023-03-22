package com.example.affirmations.ui

import com.example.affirmations.R
import com.example.affirmations.data.Datasource
import com.example.affirmations.model.Affirmation

data class DetailUiState(val affirmation: Affirmation = Datasource().loadAffirmations()[0])
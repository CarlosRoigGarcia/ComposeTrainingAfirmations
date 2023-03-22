package com.example.affirmations.ui

import com.example.affirmations.R
import com.example.affirmations.model.Affirmation

data class DetailUiState(val affirmation: Affirmation = Affirmation(1, R.string.affirmation1, R.drawable.image1,
    R.string.affirmation1,
    R.string.description,
    R.string.email1,
    R.string.phon1))
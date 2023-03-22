package com.example.affirmations.ui

import com.example.affirmations.model.Affirmation

data class MainUiState(val affirmations : List<Affirmation> = emptyList())
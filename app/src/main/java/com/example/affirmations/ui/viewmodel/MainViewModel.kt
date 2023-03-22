package com.example.affirmations.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.affirmations.data.Datasource
import com.example.affirmations.ui.MainUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel(){
    private  val _uiState = MutableStateFlow(MainUiState())
    val uiState : StateFlow<MainUiState> get() = _uiState.asStateFlow()
    init {
        affirmationListInUiState()
    }
    private fun affirmationListInUiState(){
        _uiState.value = MainUiState(affirmations = Datasource().loadAffirmations())
    }
}
package com.example.affirmations.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.affirmations.data.Datasource
import com.example.affirmations.ui.DetailUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class DetailViewModel : ViewModel() {
    private  val _uiState = MutableStateFlow(DetailUiState())
    val uiState : StateFlow<DetailUiState> get() = _uiState.asStateFlow()
     fun setDescriptionValuesById(id : Int){
        for (affirmation in Datasource().loadAffirmations()){
            if(affirmation.Id==id)
            {
                _uiState.value = DetailUiState(affirmation = affirmation)
                return
            }
        }
    }

}
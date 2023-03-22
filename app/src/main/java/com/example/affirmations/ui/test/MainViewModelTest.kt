package com.example.affirmations.ui.test

import com.example.affirmations.data.Datasource
import com.example.affirmations.ui.viewmodel.MainViewModel
import junit.framework.TestCase.assertEquals
import org.junit.Test

class MainViewModelTest {
    private val viewModel = MainViewModel()
    @Test
    fun mainViewModelTest_returnListOfAffirmations(){
        val currenUiState = viewModel.uiState.value
        val affirmationList = currenUiState.affirmations
        assertEquals(affirmationList,Datasource().loadAffirmations())
    }
}
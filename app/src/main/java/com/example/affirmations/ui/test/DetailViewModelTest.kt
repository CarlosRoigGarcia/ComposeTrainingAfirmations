package com.example.affirmations.ui.test

import com.example.affirmations.data.Datasource
import com.example.affirmations.ui.viewmodel.DetailViewModel
import junit.framework.TestCase
import junit.framework.TestCase.assertEquals
import org.junit.Test

class DetailViewModelTest {
    private val viewModel = DetailViewModel()
    @Test
    fun detailViewModelTest_IfAffirmationDefaultIdIsCorrect(){
        assertEquals(viewModel.uiState.value.affirmation,Datasource().loadAffirmations()[0])
    }
    @Test
    fun detailViewModelTest_IfAffirmationByIdIsCorrect(){
        viewModel.setDescriptionValuesById(5)
        val currenUiState = viewModel.uiState.value
        val affirmation = currenUiState.affirmation
        assertEquals(affirmation, Datasource().loadAffirmations()[4])
    }
}
package com.fortunetiasasger.exampale.presentation.screens.choosestones.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fortunetiasasger.exampale.presentation.screens.choosestones.view.ChooseStoneApi

class ViewModelChooseStone() : ViewModel() {


    private val _clickedCrafState = MutableLiveData(false)
    val  clickedCrafState: LiveData<Boolean> = _clickedCrafState

   fun clickedCrafState(state:Boolean){
        _clickedCrafState.value = state
    }

    private val _levelLoadingState = MutableLiveData(0f)
    val levelLoadingState: LiveData<Float> = _levelLoadingState

    fun levelLoadingState(state:Float){
        _levelLoadingState.value = state
    }

}

package com.fortunetiasasger.exampale.presentation.screens.gamepersonfirst.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fortunetiasasger.exampale.presentation.screens.choosestones.view.ChooseStoneApi

class ViewModelChooseStone() : ViewModel(), ChooseStoneApi {

    private val _clickedCrafState = MutableLiveData(false)
    override val  clickedCrafState: LiveData<Boolean> = _clickedCrafState

    override fun clickedCrafState(state:Boolean){
        _clickedCrafState.value = state
    }

    private val _levelLoadingState = MutableLiveData(0f)
    override val levelLoadingState: LiveData<Float> = _levelLoadingState

    override fun levelLoadingState(state:Float){
        _levelLoadingState.value = state
    }

}
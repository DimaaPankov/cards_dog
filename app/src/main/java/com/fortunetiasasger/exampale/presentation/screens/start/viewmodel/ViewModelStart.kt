package com.fortunetiasasger.exampale.presentation.screens.start.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelStart():ViewModel() {

    private val _isClickedStart = MutableLiveData<Boolean>(false)
    val isClickedStartState:LiveData<Boolean> = _isClickedStart

    fun isClickedStartState(state:Boolean){
        _isClickedStart.value = state
    }

}
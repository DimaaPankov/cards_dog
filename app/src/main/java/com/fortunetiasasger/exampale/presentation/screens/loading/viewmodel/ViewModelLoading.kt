package com.fortunetiasasger.exampale.presentation.screens.loading.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelLoading():ViewModel() {

    private val _actionGoStart = MutableLiveData(false)
    val actionGoStart:LiveData<Boolean> = _actionGoStart

    fun actionGoStartState(state:Boolean){
        _actionGoStart.value = state
    }



}
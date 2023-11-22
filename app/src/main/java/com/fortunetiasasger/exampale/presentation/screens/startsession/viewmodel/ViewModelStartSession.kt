package com.fortunetiasasger.exampale.presentation.screens.startsession.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fortunetiasasger.exampale.data.repository.StaticDataApi


class ViewModelStartSession(val date: StaticDataApi):ViewModel() {



    private val _clickedStartState = MutableLiveData<Boolean>(false)
    val clickedStartState:LiveData<Boolean> = _clickedStartState

    fun visibaleState(state:Boolean){
        _clickedStartState.value = state
    }



}
package com.fortunetiasasger.exampale.presentation.screens.game_begin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fortunetiasasger.exampale.presentation.screens.game_begin.view.BeginApi

class ViewModelBegin() : ViewModel(), BeginApi {

    private val _isClickedBegin = MutableLiveData(false)
   override val isClickedBeginState:LiveData<Boolean> = _isClickedBegin

   override fun isClickedBeginState(state:Boolean){
        _isClickedBegin.value = state
    }

}



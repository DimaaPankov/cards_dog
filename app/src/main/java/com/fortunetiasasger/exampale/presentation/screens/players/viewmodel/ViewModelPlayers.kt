package com.fortunetiasasger.exampale.presentation.screens.players.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fortunetiasasger.exampale.data.repository.StaticDataApi

class ViewModelPlayers(val date: StaticDataApi) : ViewModel() {

    private val _clickedStartState = MutableLiveData(false)
    val clickedStartState: LiveData<Boolean> = _clickedStartState

    private val _textPlayerOne = MutableLiveData("")
    val textPlayerOne: LiveData<String> = _textPlayerOne

    fun changePlayerOne(newText:String){
        date.nameFirst = newText
        _textPlayerOne.value = newText
    }



    fun clickedStartState(){
        _clickedStartState.value = true
    }
}
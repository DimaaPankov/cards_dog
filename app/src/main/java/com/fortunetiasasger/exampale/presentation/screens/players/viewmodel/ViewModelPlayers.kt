package com.fortunetiasasger.exampale.presentation.screens.players.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fortunetiasasger.exampale.presentation.screens.players.view.PlayersDateApi

class ViewModelPlayers(val date: PlayersDateApi) : ViewModel() {

    private val _clickedStartState = MutableLiveData(false)
    val clickedStartState: LiveData<Boolean> = _clickedStartState

    private val _textPlayerOne = MutableLiveData("")
    val textPlayerOne: LiveData<String> = _textPlayerOne

    private val _textPlayerTwo = MutableLiveData("")
    val textPlayerTwo: LiveData<String> = _textPlayerTwo

    fun changePlayerOne(newText:String){
        date.name = newText
        _textPlayerOne.value = newText
    }

    fun changePlayerTwo(newText:String){
        date.nameUserTwo = newText
        _textPlayerTwo.value = newText
    }


    fun clickedStartState(){
        _clickedStartState.value = true
    }
}
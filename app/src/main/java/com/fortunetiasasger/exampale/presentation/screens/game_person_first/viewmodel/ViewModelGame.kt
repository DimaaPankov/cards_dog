package com.fortunetiasasger.exampale.presentation.screens.game_person_first.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fortunetiasasger.exampale.data.models.Person

class ViewModelChooseStone() : ViewModel()
   // , ChooseGame
{


    val listCards: MutableLiveData<MutableList<Int>> = MutableLiveData(mutableListOf())

    private val _personNomber = MutableLiveData(Person.ONE)
    val personNomber: LiveData<Person> = _personNomber


    fun personNomber(person: Person) {
        _personNomber.value = person
    }

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
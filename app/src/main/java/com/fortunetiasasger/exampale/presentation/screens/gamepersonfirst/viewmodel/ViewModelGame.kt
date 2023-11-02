package com.fortunetiasasger.exampale.presentation.screens.gamepersonfirst.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fortunetiasasger.exampale.data.models.Person
import com.fortunetiasasger.exampale.presentation.screens.choosestones.view.ChooseStoneApi

class ViewModelChooseStone() : ViewModel(), ChooseStoneApi {


    override val listCards: MutableLiveData<MutableList<Int>> = MutableLiveData(mutableListOf())

    private val _personNomber = MutableLiveData(Person.ONE)
    override val personNomber: LiveData<Person> = _personNomber


    override fun personNomber(person: Person) {
        _personNomber.value = person
    }

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
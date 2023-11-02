package com.fortunetiasasger.exampale.presentation.screens.choosestones.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.fortunetiasasger.exampale.data.models.Person

interface ChooseStoneApi{
    companion object{
        val LEVEL_LOADING = 0.1435f
    }
    val listCards: MutableLiveData<MutableList<Int>>

    val personNomber:LiveData<Person>
    fun personNomber(person:Person)

    val clickedCrafState: LiveData<Boolean>
    fun clickedCrafState(state:Boolean)


    val levelLoadingState: LiveData<Float>
    fun levelLoadingState(state:Float)

    val  listStoneLeft: MutableLiveData<MutableList<Int>>
    fun listStoneLeft(stones:MutableList<Int>)

    val  listStoneRight: MutableLiveData<MutableList<Int>>
    fun listStoneRight(stones:MutableList<Int>)


}
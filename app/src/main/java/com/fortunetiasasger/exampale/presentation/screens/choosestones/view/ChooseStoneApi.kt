package com.fortunetiasasger.exampale.presentation.screens.choosestones.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.fortunetiasasger.exampale.data.models.Person
import com.fortunetiasasger.exampale.data.repository.StaticDataApi

interface ChooseStoneApi{
    companion object{
        val LEVEL_LOADING = 0.1435f
    }

  //  fun init(date: StaticDataApi)

    val clickable: MutableLiveData<Boolean>
    fun clickable(state:Boolean)

    val listCardsNow: MutableLiveData<MutableList<Int>>

    val personNomber:LiveData<Person>
    fun personNomber(person:Person)

    val clickedCrafState: LiveData<Boolean>
    fun clickedCrafState(state:Boolean)

    val levelLoadingState: LiveData<Float>
    fun levelLoadingState(state:Float)

    val  listStoneLeft: MutableLiveData<MutableList<Int>>
    fun listStoneLeftRemove(stones:MutableList<Int>)

    val  listStoneRight: MutableLiveData<MutableList<Int>>
    fun listStoneRight(stones:MutableList<Int>)
    fun cardNow(card:Int)

    var cardNow:MutableLiveData<Int>

    val  stoneLeft: Int
    fun stoneLeft(stones:Int)

    val  stoneRight: Int
    fun stoneRight(stones:Int)
}
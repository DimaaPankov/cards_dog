package com.fortunetiasasger.exampale.presentation.screens.choosestones.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fortunetiasasger.exampale.data.models.Person
import com.fortunetiasasger.exampale.data.repository.StaticDataApi
import com.fortunetiasasger.exampale.data.repository.StaticDate
import com.fortunetiasasger.exampale.presentation.screens.choosestones.view.ChooseStoneApi
import com.fortunetiasasger.exampale.utils.allStones
import com.fortunetiasasger.exampale.utils.leftStones
import com.fortunetiasasger.exampale.utils.rightStones

class ViewModelChooseStone(val date: StaticDataApi) : ViewModel(),ChooseStoneApi {

    override val listCards: MutableLiveData<MutableList<Int>> = MutableLiveData(mutableListOf())

   // val listStoneLeftPersonOne = leftStones(allStones(StaticDate.listStonesCategory))

    private val _listStoneLeft = MutableLiveData(leftStones(allStones(date.listStonesCategory)))
    override  val  listStoneLeft: MutableLiveData<MutableList<Int>> = _listStoneLeft

    override fun listStoneLeft(stones:MutableList<Int>){
        _listStoneLeft.value = stones
    }

    private val _listStoneRight = MutableLiveData(rightStones(allStones(date.listStonesCategory)))
    override val  listStoneRight: MutableLiveData<MutableList<Int>> = _listStoneRight

    override fun listStoneRight(stones:MutableList<Int>){
        _listStoneRight.value = stones
    }


  private val _nomberPerson = MutableLiveData(Person.ONE)
  override val personNomber = _nomberPerson
    override fun personNomber(nomber:Person){
        _nomberPerson.value = nomber
    }

    private val _clickedCrafState = MutableLiveData(false)
    override  val  clickedCrafState: LiveData<Boolean> = _clickedCrafState

    override fun clickedCrafState(state:Boolean){
        _clickedCrafState.value = state
    }

    private val _levelLoadingState = MutableLiveData(0f)
    override  val levelLoadingState: LiveData<Float> = _levelLoadingState

   override fun levelLoadingState(state:Float){
        _levelLoadingState.value = state
    }

}

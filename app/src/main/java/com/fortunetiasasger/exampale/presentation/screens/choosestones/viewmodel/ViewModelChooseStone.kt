package com.fortunetiasasger.exampale.presentation.screens.choosestones.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fortunetiasasger.exampale.data.models.Person
import com.fortunetiasasger.exampale.data.repository.StaticDataApi
import com.fortunetiasasger.exampale.data.repository.StaticDate
import com.fortunetiasasger.exampale.presentation.screens.choosestones.view.ChooseStoneApi
import com.fortunetiasasger.exampale.utils.allStones
import com.fortunetiasasger.exampale.utils.rightStones

class ViewModelChooseStone(val date:StaticDataApi) : ViewModel(),ChooseStoneApi {


    override var cardNow: MutableLiveData<Int> = MutableLiveData(date.cardNow)


    override fun cardNow(card: Int) {
        date.cardNow= card
    }


    override val listCardsNow: MutableLiveData<MutableList<Int>> = MutableLiveData(mutableListOf())

    val _clickable: MutableLiveData<Boolean> = MutableLiveData(true)
    override val clickable: MutableLiveData<Boolean> = _clickable

    override fun clickable(state:Boolean){
        _clickable.value = state
    }


   // val listStoneLeftPersonOne = leftStones(allStones(StaticDate.listStonesCategory))

    private val _listStoneLeft = MutableLiveData(StaticDate.listStoneLeftNow())
        // MutableLiveData(leftStones(allStones(date.listStonesCategory)) )


    override  val  listStoneLeft: MutableLiveData<MutableList<Int>> = _listStoneLeft

    override fun listStoneLeftRemove(stones:MutableList<Int>){
        _listStoneLeft.value = stones
    }

    private val _listStoneRight = MutableLiveData(
        StaticDate.listStoneRightNow()
    )
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

    private val _levelLoadingState = MutableLiveData(date.cardsLevel)
    override  val levelLoadingState: LiveData<Float> = _levelLoadingState

   override fun levelLoadingState(state:Float){
       // _levelLoadingState.value = state
       date.cardsLevel = state
       _levelLoadingState.value = date.cardsLevel
    }



    //private val _stoneLeft = MutableLiveData<Int>()
    override val  stoneLeft = date.stoneLeft



    override fun stoneLeft(stone:Int){
        date.stoneLeft = stone
        Log.d("test_stone",date.stoneLeft.toString())
    }

   // private val _stoneRight = MutableLiveData<Int>()
    override val  stoneRight = date.stoneRight

    override fun stoneRight(stone:Int){
      //  _stoneRight.value = stone
        date.stoneLeft = stone
    }



}

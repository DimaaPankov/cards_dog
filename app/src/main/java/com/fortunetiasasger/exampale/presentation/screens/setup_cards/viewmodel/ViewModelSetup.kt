package com.fortunetiasasger.exampale.presentation.screens.setup_cards.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fortunetiasasger.exampale.R
import com.fortunetiasasger.exampale.data.repository.StaticDataApi


class ViewModelSetup(val date:StaticDataApi): ViewModel() {


    private val _isClickedBack = MutableLiveData(false)
    val isClickedBackState: LiveData<Boolean> = _isClickedBack

    fun isClickedBackState(state:Boolean){
        _isClickedBack.value = state
    }

    fun addListCards(cards:Int){
        date.listCardsPersonFirst.add(cards)
    }
    var selectedCard = MutableLiveData(date.cardNow)




    private var _showCardState = MutableLiveData(R.drawable.all_card)
    val showCardState: LiveData<Int> = _showCardState



    fun showCardState(img:Int){
        _showCardState.value = img
    }

}
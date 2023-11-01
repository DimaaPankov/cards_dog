package com.fortunetiasasger.exampale.presentation.screens.setup_cards.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fortunetiasasger.exampale.R


class ViewModelSetup(): ViewModel() {


    private val _isClickedBack = MutableLiveData(false)
    val isClickedBackState: LiveData<Boolean> = _isClickedBack

    fun isClickedBackState(state:Boolean){
        _isClickedBack.value = state
    }

    private var _showCardState = MutableLiveData(R.drawable.all_card)
    val showCardState: LiveData<Int> = _showCardState

    fun showCardState(img:Int){
        _showCardState.value = img
    }

}
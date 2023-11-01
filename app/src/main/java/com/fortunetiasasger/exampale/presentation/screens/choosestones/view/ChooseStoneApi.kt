package com.fortunetiasasger.exampale.presentation.screens.choosestones.view

import androidx.lifecycle.LiveData

interface ChooseStoneApi{
    companion object{
        val LEVEL_LOADING = 0.1435f
    }
    val clickedCrafState: LiveData<Boolean>
    fun clickedCrafState(state:Boolean)
    fun levelLoadingState(state:Float)
    val levelLoadingState: LiveData<Float>


}
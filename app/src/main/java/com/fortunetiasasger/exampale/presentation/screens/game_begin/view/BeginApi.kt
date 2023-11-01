package com.fortunetiasasger.exampale.presentation.screens.game_begin.view

import androidx.lifecycle.LiveData

interface BeginApi{
    val isClickedBeginState: LiveData<Boolean>
    fun isClickedBeginState(state:Boolean)
}
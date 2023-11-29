package com.fortunetiasasger.exampale.presentation.screens.winning_game.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fortunetiasasger.exampale.data.repository.StaticDataApi
import com.fortunetiasasger.exampale.data.repository.StaticDate
import com.fortunetiasasger.exampale.presentation.activity.MainActivity
import com.fortunetiasasger.exampale.presentation.nav.Screen


class ViewModelWinningGame():ViewModel() {



  //  private val _clickedStartState = MutableLiveData<Boolean>(false)
  //  val clickedStartState:LiveData<Boolean> = _clickedStartState

    fun goOtherScreen(){
        StaticDate.reboot()
        MainActivity.navController.navigate(Screen.ScreenStart.route)
    }



}
package com.fortunetiasasger.exampale.presentation.screens.start.viewmodel

import androidx.lifecycle.ViewModel
import com.fortunetiasasger.exampale.presentation.activity.MainActivity
import com.fortunetiasasger.exampale.presentation.nav.Screen

class ViewModelStart():ViewModel() {
    fun clickStart(){
       MainActivity.navController.navigate(Screen.ScreenPlayers.route)
    }

}
package com.fortunetiasasger.exampale.presentation.screens.winning_a_move.viewmodel

import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.lifecycle.ViewModel
import com.fortunetiasasger.exampale.data.models.Person
import com.fortunetiasasger.exampale.data.repository.StaticDate
import com.fortunetiasasger.exampale.presentation.activity.MainActivity
import com.fortunetiasasger.exampale.presentation.nav.Screen
import com.fortunetiasasger.exampale.utils.whoWin

class ViewModelWinMove():ViewModel() {

    fun goToOtherScreen(){
        val personWin =
            whoWin(StaticDate.cardImgDropedPersonFirst, StaticDate.cardImgDropedPersonSecond)
        when (personWin) {
            Person.ONE -> ++StaticDate.pointsCardsFirst
            Person.TWO -> ++StaticDate.pointsCardsSecond
            else -> {
                ++StaticDate.pointsCardsFirst
                ++StaticDate.pointsCardsSecond
            }
        }


        Log.d("test_list_size",StaticDate.listCardsNow().size.toString())
        Log.d("test_list",StaticDate.listCardsNow().toString())
        Log.d("test_list",StaticDate.listCardsNow().toString())

        Handler(Looper.getMainLooper()).postDelayed ({
            if(StaticDate.listCardsNow().size>0) {
                MainActivity.navController.navigate(Screen.ScreenGamePirsonFirst.route)
            }else{
                MainActivity.navController.navigate(Screen.ScreenWinningGame.route)
            }
        },6000L)
    }

}

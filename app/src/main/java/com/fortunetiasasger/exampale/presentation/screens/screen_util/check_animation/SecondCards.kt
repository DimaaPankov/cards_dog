package com.fortunetiasasger.exampale.presentation.screens.screen_util.check_animation

import com.fortunetiasasger.exampale.presentation.activity.MainActivity
import com.fortunetiasasger.exampale.presentation.nav.Screen

enum class SecondCards(val rotate:Int,val  action:()->Unit){
    FIRST( 10, action = {MainActivity.navController.navigate(Screen.ScreenGamePirsonSecond.route)}),
    SECOND(-10, action = {MainActivity.navController.navigate(Screen.ScreenGameWin.route)})
}
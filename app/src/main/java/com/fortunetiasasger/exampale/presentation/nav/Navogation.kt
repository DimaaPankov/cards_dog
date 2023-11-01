package com.fortunetiasasger.exampale.presentation.nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fortunetiasasger.exampale.presentation.activity.MainActivity
import com.fortunetiasasger.exampale.presentation.screens.setup_cards.view.ScreenSetupCards
import com.fortunetiasasger.exampale.presentation.screens.gamepersonfirst.view.ScreenGamePersonFirst
import com.fortunetiasasger.exampale.presentation.screens.game_begin.view.ScreenGameBegin
import com.fortunetiasasger.exampale.presentation.screens.players.view.ScreenPlayers
import com.fortunetiasasger.exampale.presentation.screens.choosestones.view.ScreenChooseStones
import com.fortunetiasasger.exampale.presentation.screens.loading.view.ScreenLoading
import com.fortunetiasasger.exampale.presentation.screens.score.view.ScreenScore
import com.fortunetiasasger.exampale.presentation.screens.start.view.ScreenStart
import com.fortunetiasasger.exampale.presentation.screens.startsession.view.ScreenStartSession
import com.fortunetiasasger.exampale.presentation.screens.gamepersonsecond.view.ScreenGamePersonSecond


@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.ScreenLoading.route){

        composable(route = Screen.ScreenLoading.route){
            MainActivity.navController = navController
            ScreenLoading.ShowScreen()

            }

        composable(
            route = Screen.ScreenStart.route,
        ) {
            ScreenStart.ShowScreen()
        }
        composable(
            route = Screen.ScreenChooseStones.route,
        ) {
           ScreenChooseStones.ShowScreen()
        }
        composable(
            route = Screen.ScreenSetupCards.route,
        ) {
           ScreenSetupCards.ShowScreen()
        }
        composable(
            route = Screen.ScreenPlayers.route,
        ) {
            ScreenPlayers().ShowScreen()
        }
        composable(
            route = Screen.ScreenScore.route,
        ) {
            ScreenScore.ShowScreen()
        }

        composable(
            route = Screen.ScreenGameBegin.route,
        ) {
            ScreenGameBegin.ShowScreen()
        }

        composable(
            route = Screen.ScreenGame.route,
        ) {
            ScreenGamePersonFirst.ShowScreen()
        }
        composable(
            route = Screen.ScreenStartSession.route
        ){
            ScreenStartSession.LogicScreen()
        }

        composable(
            route = Screen.ScreenGamePirsonSecond.route
        ){
            ScreenGamePersonSecond.ShowScreen()
        }

        composable(
            route = Screen.ScreenGamePirsonFirst.route
        ){
            ScreenGamePersonFirst.ShowScreen()
        }

    }

}
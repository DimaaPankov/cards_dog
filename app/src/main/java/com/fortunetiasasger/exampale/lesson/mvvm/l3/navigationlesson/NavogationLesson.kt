package com.fortunetiasasger.exampale.lesson.mvvm.l3.navigationlesson

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun NavogationLesson(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ScreenLesson.MainScreen.route){
        composable(route = ScreenLesson.MainScreen.route){
            MainScreen().MainScreen(navController = navController)
            }

        composable(
            route = ScreenLesson.DeteilScreen.route+ "/{name}",
            arguments = listOf(
             navArgument("name"){
                 type = NavType.StringType
                 defaultValue = "philipp" }
            )
        )
        {arg ->
            ScreenTwo().ScreenTwo(arg.arguments?.getString("name")?:"")

        }

        }

}
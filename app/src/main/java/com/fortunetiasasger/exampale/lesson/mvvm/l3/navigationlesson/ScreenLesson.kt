package com.fortunetiasasger.exampale.lesson.mvvm.l3.navigationlesson

sealed class ScreenLesson(val route :String){
    object MainScreen : ScreenLesson("main_screen")
    object DeteilScreen : ScreenLesson("deteil_screen")

    fun witchArgs(vararg args:String):String{
        return buildString{
            append(route)
            args.forEach{
                arg ->
                append("/$arg")
            }
        }
    }
}

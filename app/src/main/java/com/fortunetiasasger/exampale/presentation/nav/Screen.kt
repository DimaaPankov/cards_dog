package com.fortunetiasasger.exampale.presentation.nav

sealed class Screen(val route :String){
    object ScreenLoading : Screen("ScreenLoading")
    object ScreenStart : Screen("ScreenStart")
    object ScreenChooseStones : Screen("ScreenChooseStones")
    object ScreenSetupCards : Screen("ScreenSetupCards")
    object ScreenPlayers : Screen("ScreenPlayers")
    object ScreenScore : Screen("ScreenScore")
    object ScreenGameBegin : Screen("ScreenGameBegin")
    object ScreenStartSession : Screen("ScreenStartSession")
    object ScreenGamePirsonFirst : Screen("ScreenGamePirsonFirst")
    object ScreenGamePirsonSecond : Screen("ScreenGamePirsonSecond")



    object ScreenGame : Screen("ScreenGamePersonTwo")



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

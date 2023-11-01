package com.fortunetiasasger.exampale.presentation.screens.players.view


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.fortunetiasasger.exampale.R
import com.fortunetiasasger.exampale.data.DateGamePersonTwo
import com.fortunetiasasger.exampale.data.model.Person
import com.fortunetiasasger.exampale.presentation.activity.MainActivity
import com.fortunetiasasger.exampale.presentation.nav.Screen
import com.fortunetiasasger.exampale.presentation.screens.players.viewmodel.ViewModelPlayers
import com.fortunetiasasger.exampale.screens.setup_cards.com.fortunetiasasger.exampale.theme.fontFamaly

@Preview
    @Composable
    fun showPlayers(){
   ScreenPlayers(DateGamePersonTwo).ShowScreen()
    }


class ScreenPlayers(val date: PlayersDateApi) {
    val viewModel = ViewModelPlayers(date)

    @Composable
    fun ShowScreen(){

        val playerOne =  viewModel.textPlayerOne.observeAsState(initial = "").value
        val playerTwo =  viewModel.textPlayerTwo.observeAsState(initial = "").value
        val clickedStartSate = viewModel.clickedStartState.observeAsState(initial = false).value
        val changePlayerOne:(String)->Unit = {
            viewModel.changePlayerOne(it)
        }
        val changePlayerTwo:(String)->Unit = {
            viewModel.changePlayerTwo(it)
        }
        val changeStartSate = {
           viewModel.clickedStartState()
        }
        val goStart = {
            MainActivity.navController.navigate(Screen.ScreenStartSession.route)
        }


        ScreenLogic(
            goStart = goStart,
            textOnePlayer = playerOne,
            textTwoPlayer = playerTwo,
            changePlayerOne = changePlayerOne,
            changePlayerTwo = changePlayerTwo,
            clickedStartSate = clickedStartSate,
            changeStateClickedStart = changeStartSate
        )

    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun ScreenLogic(
     goStart:()->Unit,
     textOnePlayer:String,
     textTwoPlayer:String,
     clickedStartSate:Boolean,
     changePlayerOne:(String)->Unit,
     changePlayerTwo:(String)->Unit,
     changeStateClickedStart:()->Unit
    ){

        if(clickedStartSate){
            goStart()
        }

        val constraints = ConstraintSet {
            val IVenterName = createRefFor("IVenterName")
            val TVonePlayer = createRefFor("TVonePlayer")
            val TVtwoPlayer = createRefFor("TVtwoPlayer")
            val IVfieldOne = createRefFor("IVfieldOne")
            val IVfieldTwo = createRefFor("IVfieldTwo")
            val ETplayerOne = createRefFor("ETplayerOne")
            val IVclickToStart = createRefFor("IVclickToStart")
            val ETplayerTwo = createRefFor("ETplayerTwo")
            val guideLine = createGuidelineFromBottom(0.5f)

            constrain(IVenterName) {
                top.linkTo(parent.top, margin = 40.dp)
                end.linkTo(parent.end)
                start.linkTo(parent.start)
            }

            constrain(TVonePlayer) {
                bottom.linkTo(guideLine, margin = 90.dp)
                end.linkTo(parent.end)
                start.linkTo(parent.start)
            }



            constrain(TVtwoPlayer) {
                top.linkTo(guideLine, margin = 30.dp)
                end.linkTo(parent.end)
                start.linkTo(parent.start)
            }

            constrain(IVfieldOne) {
                top.linkTo(TVonePlayer.bottom, margin = 30.dp)
                end.linkTo(parent.end)
                start.linkTo(parent.start)
            }

            constrain(IVfieldTwo) {
                top.linkTo(TVtwoPlayer.bottom, margin = 30.dp)
                end.linkTo(parent.end)
                start.linkTo(parent.start)
            }

            constrain(IVclickToStart) {
                bottom.linkTo(parent.bottom, margin = 50.dp)
                end.linkTo(parent.end)
                start.linkTo(parent.start)
            }

            constrain(ETplayerOne) {
                top.linkTo(IVfieldOne.top)
                end.linkTo(parent.end)
                start.linkTo(parent.start)
            }

            constrain(ETplayerTwo) {
                top.linkTo(IVfieldTwo.top, margin = 15.dp)
                end.linkTo(parent.end)
                start.linkTo(parent.start)
            }

        }

        Image(
            painter = painterResource(
                id = R.drawable.background)
            , contentDescription =""
            , modifier = Modifier.fillMaxSize()
            , contentScale = ContentScale.Crop
        )

      ConstraintLayout(constraints, modifier = Modifier.fillMaxSize()) {
          Image(
              painter = painterResource(
                  id = R.drawable.enter_name_title
              )
              , contentDescription =""
              , modifier = Modifier
                  .layoutId("IVenterName")
                  .alpha(0f)
                  .fillMaxWidth(0.8f)
                  .fillMaxHeight(0.1f)
          )




          Image(
              painter = painterResource(
                  id = R.drawable.enter_name_for_player_name
              )
              , contentDescription =""
              , modifier = Modifier
                  .alpha(0f)
                  .layoutId("IVfieldOne")
                  .fillMaxWidth(0.8f)
                  .fillMaxHeight(0.1f)
          )

          Image(
              painter = painterResource(id = R.drawable.click_to_start),
              contentDescription = "painter"
              ,modifier = Modifier
                  .layoutId("IVclickToStart")
                  .fillMaxHeight(0.09f)
                  .fillMaxWidth(0.8f)
                  .clickable {
                      changeStateClickedStart()
                  }
          )

        /*  Image(
              painter = painterResource(
                  id = R.drawable.enter_name_for_player_name
              )
              , contentDescription =""
              , modifier = Modifier
                  .layoutId("IVfieldTwo")
                  .alpha(0f)
                  .fillMaxWidth(0.8f)
                  .fillMaxHeight(0.1f)
          )
          */

        Text(
              text =  if(DateGamePersonTwo.listCards.User == Person.ONE) {
                  "1 player"
              }else{
                  "2 player"
              }
              , modifier = Modifier
                  .layoutId("TVonePlayer")
              ,fontSize =70.sp
              ,color = Color.White
              , fontFamily = fontFamaly
          )

        /*  Text(
              text = "2 player"
              ,modifier = Modifier
               .layoutId("TVtwoPlayer")
              ,fontSize =70.sp
              ,color = Color.White
              ,fontFamily = fontFamaly
          )
*/
          TextField(
              value = textOnePlayer,
              modifier = Modifier
                  .layoutId("ETplayerOne")
                  .fillMaxWidth(0.8f)
                  .fillMaxHeight(0.07f),
              textStyle = TextStyle(fontSize=25.sp),
              onValueChange = {newText ->
                 // Date.nameUserOne = newText
                  //firstName.value = newText
                  changePlayerOne(newText)
              }
          )


/*
          TextField(
              value = textTwoPlayer,
              modifier = Modifier
                  .layoutId("ETplayerTwo")
                  .fillMaxWidth(0.8f)
                  .fillMaxHeight(0.07f),
              textStyle = TextStyle(fontSize=25.sp),
              onValueChange = {newText ->
                 // Date.nameUserOne = newText
                 //secondName.value = newText
                  changePlayerTwo(newText)
              }
          )

 */


    }
}


}


package com.fortunetiasasger.exampale.presentation.screens.players.view


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
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
import com.fortunetiasasger.exampale.data.repository.StaticDate
import com.fortunetiasasger.exampale.presentation.screens.game_person_second.viewmodel.ViewModelPlayers

@Preview
    @Composable
    fun showPlayers(){
   ScreenPlayers(ViewModelPlayers(StaticDate)).ShowScreen()
    }


class ScreenPlayers(val viewModel: ViewModelPlayers) {
    @Composable
    fun ShowScreen(){
        val playerOne = viewModel.titleNow.observeAsState(initial = "").value

        val changeStartSate = {
           viewModel.clickedStart()
        }

        ScreenLogic(
            textPlayer = playerOne?:"",
            changeStateClickedStart = changeStartSate
        )

    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun ScreenLogic(
     textPlayer:String,
     changeStateClickedStart:()->Unit
    ){


        val constraints = ConstraintSet {
            val IVenterName = createRefFor("IVenterName")
            val TVonePlayer = createRefFor("TVonePlayer")
            val TVtwoPlayer = createRefFor("TVtwoPlayer")
            val IVfieldOne = createRefFor("IVfieldOne")
            val IVfieldTwo = createRefFor("IVfieldTwo")
            val ETplayerOne = createRefFor("ETplayer")
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

    TextField(
        value =  textPlayer,
        modifier = Modifier
            .layoutId("ETplayer")
            .fillMaxWidth(0.8f)
            .fillMaxHeight(0.08f),
        textStyle = TextStyle(fontSize=25.sp),
        onValueChange = { newText ->

            viewModel.changeNameNow(newText)
        })
      }
    }

}


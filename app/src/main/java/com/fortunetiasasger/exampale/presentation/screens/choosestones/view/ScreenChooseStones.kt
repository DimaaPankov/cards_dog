package com.fortunetiasasger.exampale.presentation.screens.choosestones.view

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.fortunetiasasger.exampale.R
import com.fortunetiasasger.exampale.screens.setup_cards.com.fortunetiasasger.exampale.theme.Cards_spels_plus_composeTheme
import com.fortunetiasasger.exampale.data.models.Person
import com.fortunetiasasger.exampale.data.repository.StaticDate
import com.fortunetiasasger.exampale.presentation.activity.MainActivity
import com.fortunetiasasger.exampale.presentation.nav.Screen
import com.fortunetiasasger.exampale.presentation.screens.choosestones.viewmodel.ViewModelChooseStone
import kotlinx.coroutines.delay


@Preview(showBackground = true)
    @Composable
    fun ShowChooseStones() {
        Cards_spels_plus_composeTheme {
            ScreenChooseStones(ViewModelChooseStone(StaticDate)).ShowScreen()
        }
    }

  class ScreenChooseStones(
      private val viewModel:ChooseStoneApi
  ) {
      @Composable
      fun ShowScreen() {
          var levelLoadingState = viewModel.levelLoadingState.observeAsState(0f).value
          val clickedCraftState = viewModel.clickedCrafState.observeAsState(false).value
          val listStoneLeft = viewModel.listStoneLeft.observeAsState().value
          val listStoneRight = viewModel.listStoneRight.observeAsState().value

          if(clickedCraftState){
              LaunchedEffect(true) {
                  delay(500L)
                  viewModel.clickedCrafState(false)
      //               Log.d("test_1",DateGamePersonTwo.listCards.size.toString())
                  if((viewModel.listCards.value?.size?:0) ==5){

                      if(viewModel.personNomber.value == Person.ONE){
                          viewModel.personNomber(Person.TWO)
                          viewModel.levelLoadingState(0f)
                              //    DateGamePersonTwo.listCards = mutableListOf()
                      }else{
                          MainActivity.navController.navigate(Screen.ScreenGameBegin.route)
                          return@LaunchedEffect
                      }

                      MainActivity.navController.navigate(Screen.ScreenPlayers.route)
                      return@LaunchedEffect

                  }else {
                      MainActivity.navController.navigate(Screen.ScreenSetupCards.route)
                      return@LaunchedEffect
                  }

              }
          }

          ConstraintLayout(
              constraintSet = constraints,
              modifier = Modifier
                  .fillMaxSize()
          ) {

              Image(
                  painter = painterResource(id = R.drawable.background),
                  modifier = Modifier
                      .fillMaxSize(),
                  contentScale = ContentScale.Crop,
                  contentDescription = ""
              )


              PagerStone(
                  listImg = listStoneLeft?.toList()?: listOf(),
                  id = "ColumLeft",
                  side = SidesStone.Lefr
              )
              PagerStone(
                  listImg = listStoneRight?.toList()?: listOf(),
                  id = "ColumRight",
                  side = SidesStone.Right
              )


              Image(
                  painter = painterResource(
                      id = R.drawable.img_1
                  ),
                  contentDescription = "",
                  contentScale = ContentScale.Crop,
                  modifier = Modifier
                      .fillMaxWidth()
                      .fillMaxHeight(0.4f)
                      .layoutId("IVbackgroundBottom")
              )

              Image(
                  painter = painterResource(id = R.drawable.baraban_2),
                  modifier = Modifier
                      .layoutId("IVgameDrum")
                      .size(350.dp),

                  contentDescription = ""
              )



              Image(
                  modifier = Modifier
                      .layoutId("IVclickCraft")
                      .fillMaxWidth(0.9f)
                      .clickable {
                          if (!clickedCraftState) {
                              listStoneLeft.remove(DateGamePersonTwo.stoneLeft)
                              listStoneRight.remove(DateGamePersonTwo.stoneRight)
                              viewModel.levelLoadingState(
                                  levelLoadingState + ChooseStoneApi.LEVEL_LOADING
                              )
                          }

                          viewModel.clickedCrafState(true)
                      }
                      .height(70.dp),
                  painter = painterResource(id = R.drawable.craft),
                  contentDescription = ""
              )

              Image(
                  modifier = Modifier
                      .layoutId("IVclickPreview")
                      .fillMaxWidth(0.9f)
                      .height(60.dp),
                  painter = painterResource(id = R.drawable.previev),
                  contentDescription = ""
              )

              Image(
                  modifier = Modifier
                      .layoutId("IVback")
                      .fillMaxWidth(0.2f)
                      .fillMaxHeight(0.1f),
                  painter = painterResource(id = R.drawable.big_reset),
                  contentDescription = ""
              )

              Image(
                  modifier = Modifier
                      .layoutId("IVsound")
                      .fillMaxWidth(0.2f)
                      .fillMaxHeight(0.1f)
                      .height(60.dp),
                  painter = painterResource(id = R.drawable.sound_and_music_on),
                  contentDescription = ""
              )

              Image(
                  modifier = Modifier
                      .layoutId("IVloadingOut")
                      .fillMaxWidth(0.9f)
                      .fillMaxHeight(0.1f)
                      .height(60.dp),
                  painter = painterResource(id = R.drawable.indicator_bar),
                  contentDescription = ""
              )
              Image(
                  contentScale = ContentScale.Crop,
                  modifier = Modifier
                      .layoutId("IVloadingIn")

                      .fillMaxWidth(levelLoadingState)
                      //.fillMaxSize(levelLoadingState)
                      .height(36.dp),
                  painter = painterResource(id = R.drawable.indicator),
                  contentDescription = ""
              )

          }
      }

      val constraints = ConstraintSet {
          val IVclickCraft = createRefFor("IVclickCraft")
          val IVclickPreview = createRefFor("IVclickPreview")
          val IVgameDrum = createRefFor("IVgameDrum")
          val IVback = createRefFor("IVback")
          val IVsound = createRefFor("IVsound")
          val ColumLeft = createRefFor("ColumLeft")
          val ColumRight = createRefFor("ColumRight")
          val IVloadingIn = createRefFor("IVloadingIn")
          val IVloadingOut = createRefFor("IVloadingOut")
          val IVbackgroundBottom = createRefFor("IVbackgroundBottom")

          constrain(ColumLeft) {
              top.linkTo(IVgameDrum.top, margin = 80.dp)
              start.linkTo(IVgameDrum.start, margin = 50.dp)
          }

          constrain(ColumRight) {
              top.linkTo(IVgameDrum.top, margin = 80.dp)
              end.linkTo(IVgameDrum.end, margin = 45.dp)
          }



          constrain(IVbackgroundBottom) {
              bottom.linkTo(parent.bottom)
              start.linkTo(parent.start)
          }

          constrain(IVloadingOut) {
              bottom.linkTo(IVgameDrum.top)
              top.linkTo(IVback.top, margin = 100.dp)
              start.linkTo(parent.start)
              end.linkTo(parent.end)
          }

          constrain(IVloadingIn) {
              bottom.linkTo(IVgameDrum.top)
              top.linkTo(IVback.top, margin = 100.dp)
              start.linkTo(IVloadingOut.start, margin = 7.dp)
          }

          constrain(IVclickCraft) {
              bottom.linkTo(parent.bottom, margin = 26.dp)
              end.linkTo(parent.end)
              start.linkTo(parent.start)
          }
          constrain(IVclickPreview) {
              bottom.linkTo(IVclickCraft.top, margin = 35.dp)
              end.linkTo(parent.end)
              start.linkTo(parent.start)
          }
          constrain(IVgameDrum) {
              bottom.linkTo(IVclickPreview.bottom, margin = 35.dp)
              top.linkTo(IVback.bottom)
              end.linkTo(parent.end)
              start.linkTo(parent.start)
          }
          constrain(IVsound) {
              top.linkTo(parent.top, margin = 20.dp)
              end.linkTo(parent.end, margin = 20.dp)
          }
          constrain(IVback) {
              top.linkTo(parent.top, margin = 20.dp)
              start.linkTo(parent.start, margin = 20.dp)
          }

      }
  }





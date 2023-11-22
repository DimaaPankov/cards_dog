package com.fortunetiasasger.exampale.presentation.screens.setup_cards.view

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
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
import com.fortunetiasasger.exampale.data.models.Person
import com.fortunetiasasger.exampale.data.repository.StaticDate
import com.fortunetiasasger.exampale.presentation.activity.MainActivity
import com.fortunetiasasger.exampale.presentation.nav.Screen
import com.fortunetiasasger.exampale.presentation.screens.setup_cards.viewmodel.ViewModelSetup
var i = 0
class ScreenSetupCards( val viewModel:ViewModelSetup){
  //  val viewModel  = ViewModelSetup(StaticDate)


        @Composable
        fun ShowScreen() {

            // val showCard = viewModel.showCardState.observeAsState(R.drawable.all_cards0).value
            Log.d("test_qqq",(++i).toString())

            val clickedBackState = viewModel.isClickedBackState.observeAsState(initial = false).value
            viewModel.isClickedBackState(false)
            val selectedCard = viewModel.selectedCard.value
            Log.d("test_3",selectedCard.toString())


           if(clickedBackState){
                StaticDate.listCardsAdd(selectedCard?:0)
                Log.d("test_3331",StaticDate.listCardsNow().size.toString())
                if(StaticDate.listCardsNow().size==6){
                    if(
                    //viewModel.personNomber.value
                        StaticDate.person == Person.ONE
                    ){
                        MainActivity.navController.navigate(Screen.ScreenPlayers.route)
                        StaticDate.person = Person.TWO
                        StaticDate.cardsLevel = 0f
                    }else{
                        MainActivity.navController.navigate(Screen.ScreenGameBegin.route)
                    }

                }else{
                    MainActivity.navController.navigate(Screen.ScreenChooseStones.route)
                }

            }

            Image(
                painter = painterResource(
                    id = R.drawable.background
                ),
                contentDescription = "",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            ConstraintLayout(
                constraintsFore(), modifier = Modifier
                    .fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.setup_cards),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxWidth(0.85f)
                        .fillMaxHeight(0.11f)
                        .layoutId("IVpreviewCardText")
                )

                Image(
                    painter = painterResource(
          //              id = showCard
                        id = selectedCard?:0
                    ),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxHeight(0.5f)
                        .fillMaxWidth(0.65f)
                        .layoutId("IVpreviewCardImg")
                )

                Image(
                    painter = painterResource(id = R.drawable.back),
                    contentDescription = "",
                    modifier = Modifier
                        .clickable {
                            //viewModel.addListCards(selectedCard?:0)
                           //.listCardsPersonFirst.add(selectedCard?:0)
                            viewModel.isClickedBackState(true)
                        }
                        .fillMaxHeight(0.15f)
                        .fillMaxWidth(0.7f)
                        .layoutId("IVback")
                )


            }

        }

        private fun constraintsFore() = ConstraintSet {
            val IVpreviewCardText = createRefFor(id = "IVpreviewCardText")
            val IVpreviewCardImg = createRefFor(id = "IVpreviewCardImg")
            val IVback = createRefFor(id = "IVback")

            constrain(IVpreviewCardText) {
                top.linkTo(parent.top, margin = 40.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }

            constrain(IVback) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom, margin = 20.dp)
            }

            constrain(IVpreviewCardImg) {
                top.linkTo(IVpreviewCardText.bottom)
                start.linkTo(parent.start)
                bottom.linkTo(IVback.top)
                end.linkTo(parent.end)
            }

            constrain(IVpreviewCardText) {
                top.linkTo(parent.top, margin = 40.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }

        }
    }

@Preview(showBackground = true)
@Composable
fun showFoure() {
    ScreenSetupCards(ViewModelSetup(StaticDate)).ShowScreen()
}

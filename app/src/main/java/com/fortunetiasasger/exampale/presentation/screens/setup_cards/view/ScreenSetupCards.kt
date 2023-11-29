package com.fortunetiasasger.exampale.presentation.screens.setup_cards.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.fortunetiasasger.exampale.R
import com.fortunetiasasger.exampale.data.repository.StaticDate
import com.fortunetiasasger.exampale.presentation.screens.setup_cards.viewmodel.ViewModelSetup

var i = 0
class ScreenSetupCards( val viewModel:ViewModelSetup){
  //  val viewModel  = ViewModelSetup(StaticDate)


        @Composable
        fun ShowScreen() {


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
                        id = viewModel.selectedCard.value?:0
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
                            viewModel.clickBack()
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

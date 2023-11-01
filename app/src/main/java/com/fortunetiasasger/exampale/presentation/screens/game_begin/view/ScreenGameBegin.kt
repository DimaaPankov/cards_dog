package com.fortunetiasasger.exampale.presentation.screens.game_begin.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.fortunetiasasger.exampale.R
import com.fortunetiasasger.exampale.presentation.activity.MainActivity
import com.fortunetiasasger.exampale.presentation.nav.Screen
import com.fortunetiasasger.exampale.presentation.screens.game_begin.viewmodel.ViewModelBegin
import com.fortunetiasasger.exampale.screens.setup_cards.com.fortunetiasasger.exampale.theme.fontFamaly

class ScreenGameBegin {
    @Composable
    fun ShowScreen() {

        val viewModel  = ViewModelBegin()
        val clickedBeginState = viewModel.isClickedBeginState.observeAsState(initial = false).value

        if(clickedBeginState){
            MainActivity.navController.navigate(Screen.ScreenGame.route)
        }

        Image(
            painter = painterResource(
                id = R.drawable.background
            ), contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        ConstraintLayout(constraints(), modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(
                    id = R.drawable.bar_for_windows
                ), contentDescription = "", modifier = Modifier
                    .layoutId("IVframe")
                    .fillMaxWidth(0.9f)
                    .fillMaxHeight(0.4f)
            )

            Image(
                painter = painterResource(
                    id = R.drawable.go
                ), contentDescription = "", modifier = Modifier
                    .layoutId("IVokey")
                    .fillMaxWidth(0.7f)
                    .fillMaxHeight(0.085f)
                    .clickable {
                        viewModel.isClickedBeginState(true)
                        //MainActivity.navController.navigate(Screen.ScreenGame.route)
                    }
            )

            Box(
                modifier = Modifier
                    .layoutId("TVresultPoints")
                    .fillMaxWidth(0.8f)
                    .fillMaxHeight(0.125f)
            ) {
                Text(
                    text = "LET THE GAME BEGINS",
                    modifier = Modifier
                        .fillMaxSize(),
                    textAlign = TextAlign.Center,
                    fontSize = 41.sp,
                    color = Color.White,
                    fontFamily = fontFamaly
                )
            }


        }
    }

    private fun constraints() = ConstraintSet {
        val IVFrame = createRefFor(id = "IVframe")
        val IVokey = createRefFor(id = "IVokey")
        val TVresult = createRefFor(id = "TVresultPoints")
        constrain(IVFrame) {
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(IVokey) {
            bottom.linkTo(IVFrame.bottom, margin = 0.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(TVresult) {
            top.linkTo(IVFrame.top)
            bottom.linkTo(IVokey.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun showGameBegin() {
    ScreenGameBegin().ShowScreen()
}

package com.fortunetiasasger.exampale.presentation.screens.winning_game.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.fortunetiasasger.exampale.R
import com.fortunetiasasger.exampale.data.repository.StaticDate
import com.fortunetiasasger.exampale.presentation.activity.MainActivity
import com.fortunetiasasger.exampale.presentation.nav.Screen
import com.fortunetiasasger.exampale.presentation.screens.loading.view.ScreenLoading.viewModel
import com.fortunetiasasger.exampale.presentation.screens.startsession.viewmodel.ViewModelStartSession
import com.fortunetiasasger.exampale.presentation.screens.winning_game.viewmodel.ViewModelWinningGame
import com.fortunetiasasger.exampale.screens.setup_cards.com.fortunetiasasger.exampale.theme.fontFamaly
import kotlinx.coroutines.delay

@Preview
@Composable
fun PreviewScreenWinningGame(){
    ScreenWinningGame.ShowScreen()
}

object ScreenWinningGame {

    val viewMode = ViewModelWinningGame()
    @Composable
    fun ShowScreen() {
        var rotationState = remember { mutableStateOf(0f) }
        var scaleState = remember { mutableStateOf(0.5f) }

        LaunchedEffect(Unit) {
            var turnCount = 0
            if (turnCount < 4) {
                for (angle in 0..720) {
                    rotationState.value = angle.toFloat()
                    scaleState.value = 0.5f + 0.5f * (angle.toFloat() / 720f)


                    delay(2L)
                }
                turnCount++
            }
        }

        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
        ) {
            val (bac, textWin, ava, back, textScores) = createRefs()

            Image(
                painter = painterResource(id = R.drawable.background),
                contentDescription = "Background",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .constrainAs(bac) {
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                        start.linkTo(parent.start)
                        bottom.linkTo(parent.bottom)
                    }
                    .fillMaxSize()
            )

            Text(
                titleWin() +"\nWIN! "
                        , fontSize = 54.sp, color = Color(0xFFFDFDFD),
                fontWeight = FontWeight.Bold,
                fontFamily = fontFamaly,
                textAlign = TextAlign.Center,
                modifier = Modifier.constrainAs(textWin) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                    bottom.linkTo(textScores.top)
                }
            )
            Text((StaticDate.pointsCardsFirst.toString() + ":" + StaticDate.pointsCardsSecond.toString()),
                fontSize = 44.sp,
                fontFamily = fontFamaly,
                color = Color(0xFFFDFDFD),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.constrainAs(textScores) {
                    top.linkTo(textWin.bottom)
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                    bottom.linkTo(ava.top)
                })

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Avatar",
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .constrainAs(ava) {
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                        start.linkTo(parent.start)
                        bottom.linkTo(parent.bottom)
                    }
                    .graphicsLayer(
                        rotationY = rotationState.value,
                        scaleX = scaleState.value,
                        scaleY = scaleState.value
                    )
            )
            Image(painter = painterResource(id = R.drawable.reset), contentDescription = "Back",
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .constrainAs(back) {
                        top.linkTo(ava.bottom)
                        end.linkTo(parent.end)
                        start.linkTo(parent.start)
                        bottom.linkTo(parent.bottom)
                    }
                    .clickable {
                        viewModel.goOtherScreen()
                    }

            )
        }
    }
    private fun titleWin()=when{
        StaticDate.pointsCardsFirst>StaticDate.pointsCardsSecond ->StaticDate.nameFirst
        StaticDate.pointsCardsFirst<StaticDate.pointsCardsSecond ->StaticDate.nameSecond
        else ->"draw"
    }

}
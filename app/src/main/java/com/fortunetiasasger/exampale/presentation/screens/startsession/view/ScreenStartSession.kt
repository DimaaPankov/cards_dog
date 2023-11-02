package com.fortunetiasasger.exampale.presentation.screens.startsession.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.fortunetiasasger.exampale.R
import com.fortunetiasasger.exampale.data.DateGamePersonTwo
import com.fortunetiasasger.exampale.data.models.Stone
import com.fortunetiasasger.exampale.presentation.activity.MainActivity
import com.fortunetiasasger.exampale.presentation.nav.Screen
import com.fortunetiasasger.exampale.presentation.screens.startsession.viewmodel.ViewModelStartSession
import kotlinx.coroutines.delay


@Preview(showBackground = true)
@Composable
fun ShowStartSession() {
    ScreenStartSession.LogicScreen()
}

object ScreenStartSession {

    val viewModel = ViewModelStartSession(date = DateGamePersonTwo)


    @Composable
    fun LogicScreen() {
        val clickedStart = viewModel.clickedStartState.observeAsState(false).value

        ShowScreen(visibility = clickedStart)
        if(clickedStart){
            LaunchedEffect(true ){
                delay(3000)
              MainActivity.navController.navigate(Screen.ScreenChooseStones.route)
        }

        }

    }

    @Composable
    fun ShowScreen(visibility: Boolean) {
        ConstraintLayout(
            constraintSet = constraints(),
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

            Image(
                painter = painterResource(id = R.drawable.baraban_three),
                modifier = Modifier
                    .layoutId("IVgameDrum")
                    .height(350.dp)
                    .width(350.dp),

                contentDescription = ""
            )



            Image(
                modifier = Modifier
                    .layoutId("IVback")
                    .fillMaxWidth(0.2f)
                    .fillMaxHeight(0.1f)
                    .clickable {
                        viewModel.visibaleState(true)
                    }
                ,
                painter = painterResource(id = R.drawable.reset),
                contentDescription = ""
            )

            AnimatedVisibility(
                visible = !visibility,
                modifier = Modifier
                    .layoutId("IVgoSelectScreen")
                    .fillMaxWidth(0.3f)
                    .fillMaxHeight(0.15f)
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable {
                            viewModel.visibaleState(true)
                        },
                    painter = painterResource(id = R.drawable.reset),
                    contentDescription = ""
                )
            }

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
                painter = painterResource(id = R.drawable.start_session),
                contentDescription = ""
            )

        }
        AnimatedVisibility(
            visible = visibility,
            enter = slideInVertically()
                    + expandVertically()
                    + fadeIn(),
            modifier = Modifier.fillMaxSize()
        ) {
            visibilityComponent(DateGamePersonTwo.listStonesCategory)
        }
    }

    fun constraints() = ConstraintSet {
        val IVgoSelectScreen = createRefFor("IVgoSelectScreen")
        val IVclickPreview = createRefFor("IVclickPreview")
        val IVgameDrum = createRefFor("IVgameDrum")
        val IVback = createRefFor("IVback")
        val IVsound = createRefFor("IVsound")
        val IVloadingIn = createRefFor("IVloadingIn")
        val IVloadingOut = createRefFor("IVloadingOut")


        constrain(IVloadingOut) {
            bottom.linkTo(IVgameDrum.top)
            top.linkTo(IVback.top, margin = 100.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(IVloadingIn) {
            bottom.linkTo(IVgameDrum.top)
            top.linkTo(IVback.top, margin = 100.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(IVgoSelectScreen) {
            bottom.linkTo(parent.bottom, margin = 26.dp)
            end.linkTo(parent.end)
            start.linkTo(parent.start)
        }
        constrain(IVclickPreview) {
            bottom.linkTo(IVgoSelectScreen.top, margin = 35.dp)
            end.linkTo(parent.end)
            start.linkTo(parent.start)
        }
        constrain(IVgameDrum) {
            bottom.linkTo(parent.bottom)
            top.linkTo(parent.top)
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

    fun constraintStone() = ConstraintSet {
        val IVslotOne = createRefFor("IVslotOne")
        val IVslotTwo = createRefFor("IVslotTwo")
        val IVslotThree = createRefFor("IVslotThree")
        val IVslotFoure = createRefFor("IVslotFoure")
        val IVslotFive = createRefFor("IVslotFive")
        val IVslotSix = createRefFor("IVslotSix")
        val TVcountOne = createRefFor("TVcountOne")
        val TVcountTwo = createRefFor("TVcountTwo")
        val TVcountThree = createRefFor("TVcountThree")
        val TVcountFoure = createRefFor("TVcountFoure")
        val TVcountFive = createRefFor("TVcountFive")
        val TVcountSix = createRefFor("TVcountSix")
        val IVgameDrum = createRefFor("IVgameDrum")
        val centerGuideline = createGuidelineFromBottom(0.5f)

        constrain(IVgameDrum) {
            bottom.linkTo(parent.bottom)
            top.linkTo(parent.top)
            end.linkTo(parent.end)
            start.linkTo(parent.start)
        }

        constrain(IVslotOne) {
            bottom.linkTo(centerGuideline, margin = 30.dp)
            start.linkTo(IVgameDrum.start, margin = 70.dp)
        }

        constrain(IVslotTwo) {
            bottom.linkTo(centerGuideline, margin = 30.dp)
            end.linkTo(parent.end)
            start.linkTo(parent.start, margin = 10.dp)
        }

        constrain(IVslotThree) {
            bottom.linkTo(centerGuideline, margin = 30.dp)
            end.linkTo(parent.end, margin = 80.dp)

        }

        constrain(IVslotFoure) {
            top.linkTo(centerGuideline, margin = 0.dp)
            start.linkTo(IVgameDrum.start, margin = 70.dp)
        }
        constrain(IVslotFive) {
            top.linkTo(centerGuideline, margin = 0.dp)
            end.linkTo(parent.end)
            start.linkTo(parent.start, margin = 0.dp)
        }
        constrain(IVslotSix) {
            top.linkTo(centerGuideline, margin = 0.dp)
            end.linkTo(parent.end, margin = 80.dp)
        }


        constrain(TVcountOne) {
            top.linkTo(IVslotOne.bottom, margin = 2.dp)
            start.linkTo(IVslotOne.end, margin = 2.dp)
        }

        constrain(TVcountTwo) {
            top.linkTo(IVslotTwo.bottom, margin = 2.dp)
            start.linkTo(IVslotTwo.end, margin = 2.dp)
        }

        constrain(TVcountThree) {
            top.linkTo(IVslotThree.bottom, margin = 2.dp)
            start.linkTo(IVslotThree.end, margin = 2.dp)

        }

        constrain(TVcountFoure) {
            top.linkTo(IVslotFoure.bottom, margin = 2.dp)
            start.linkTo(IVslotFoure.end)
        }
        constrain(TVcountFive) {
            top.linkTo(IVslotFive.bottom, margin = 2.dp)
            start.linkTo(IVslotFive.end)
        }
        constrain(TVcountSix) {
            top.linkTo(IVslotSix.bottom, margin = 2.dp)
            start.linkTo(IVslotSix.end)
        }
    }


    @Composable
    fun visibilityComponent(listStones:List<Stone>) {


        ConstraintLayout(
            constraintSet = constraintStone(),
            modifier = Modifier
                .fillMaxSize()
        ) {

            Image(
                painter = painterResource(id = R.drawable.baraban_three),
                modifier = Modifier
                    .layoutId("IVgameDrum")
                    .alpha(0f)
                    .height(350.dp)
                    .width(350.dp),

                contentDescription = ""
            )

                Image(
                    painter = painterResource(
                        id = listStones[0].img
                    ), contentDescription = "one", modifier = Modifier
                        .fillMaxWidth(0.1f)
                        .fillMaxHeight(0.06f)
                        .layoutId("IVslotOne")
                )

                Image(
                    painter = painterResource(
                        id =listStones[1].img
                    ), contentDescription = "one", modifier = Modifier
                        .fillMaxWidth(0.1f)
                        .fillMaxHeight(0.06f)
                        .layoutId("IVslotTwo")
                )
                Image(
                    painter = painterResource(
                        id = listStones[2].img
                    ), contentDescription = "one", modifier = Modifier
                        .fillMaxWidth(0.1f)
                        .fillMaxHeight(0.06f)
                        .layoutId("IVslotThree")
                )
                Image(
                    painter = painterResource(
                        id = listStones[3].img
                    ), contentDescription = "one", modifier = Modifier
                        .fillMaxWidth(0.1f)
                        .fillMaxHeight(0.06f)
                        .layoutId("IVslotFoure")
                )
                Image(
                    painter = painterResource(
                        id = listStones[4].img
                    ), contentDescription = "one", modifier = Modifier
                        .fillMaxWidth(0.1f)
                        .fillMaxHeight(0.06f)
                        .layoutId("IVslotFive")
                )
                Image(
                    painter = painterResource(
                        id = listStones[5].img
                    ), contentDescription = "one", modifier = Modifier
                        .fillMaxWidth(0.1f)
                        .fillMaxHeight(0.06f)
                        .layoutId("IVslotSix")
                )

                Text(
                    text = listStones[0].count.toString(),
                    fontSize = 15.sp,
                    color = colorResource(id = R.color.white),
                    modifier = Modifier
                        .fillMaxWidth(0.1f)
                        .fillMaxHeight(0.06f)
                        .layoutId("TVcountOne")
                )

                Text(
                    text = listStones[1].count.toString(),
                    fontSize = 15.sp,
                    color = colorResource(id = R.color.white), modifier = Modifier
                        .fillMaxWidth(0.1f)
                        .fillMaxHeight(0.06f)
                        .layoutId("TVcountTwo")
                )
                Text(
                    text = listStones[2].count.toString(),
                    fontSize = 15.sp,
                    color = colorResource(id = R.color.white), modifier = Modifier
                        .fillMaxWidth(0.1f)
                        .fillMaxHeight(0.06f)
                        .layoutId("TVcountThree")
                )
                Text(
                    text = listStones[3].count.toString(),
                    fontSize = 17.sp,
                    color = colorResource(id = R.color.white), modifier = Modifier
                        .wrapContentSize()
                        .layoutId("TVcountFoure")
                )
                Text(
                    text = listStones[4].count.toString(),
                    fontSize = 15.sp,
                    color = colorResource(id = R.color.white), modifier = Modifier
                        .fillMaxWidth(0.1f)
                        .fillMaxHeight(0.06f)
                        .layoutId("TVcountFive")
                )
                Text(
                    text = listStones[5].count.toString(),
                    fontSize = 15.sp,
                    color = colorResource(id = R.color.white), modifier = Modifier
                        .fillMaxWidth(0.1f)
                        .fillMaxHeight(0.06f)
                        .layoutId("TVcountSix")
                )

            }

    }
}

@Preview
@Composable
fun showaaaa(){
    ScreenStartSession.visibilityComponent(
        DateGamePersonTwo.listStonesCategory
    )
}



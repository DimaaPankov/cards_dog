package com.fortunetiasasger.exampale.presentation.screens.winning_a_move.usecases

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.fortunetiasasger.exampale.R
import kotlinx.coroutines.delay

@Preview
@Composable
fun PreviewanimateVisibilityBottomCard(){
    animateInvisibilityBottomCard()
}
@Composable
fun animateInvisibilityBottomCard() {

    var visibility by remember {
        mutableStateOf(true)
    }

    LaunchedEffect(true){
        delay(400)
        visibility = false
    }


    AnimatedVisibility(
        visible = visibility,
        modifier = Modifier
            .fillMaxSize()
    ) {
        ConstraintLayout(
            constraintSet = constraintVisibilityCard(),
            modifier = Modifier
                .fillMaxSize()
        ) {



            Image(
                painter = painterResource(id = R.drawable.rubashka_kart),
                modifier = Modifier
                    .width(270.dp)
                    .height(270.dp)
                    .layoutId("IVoneCard")
                    .padding(start = 0.dp, end = 120.dp),
                contentDescription = null
            )



            Image(
                painter = painterResource(id = R.drawable.rubashka_kart),
                modifier = Modifier
                    .width(150.dp + 80.dp)
                    .height(270.dp)
                    .layoutId("IVtwoCard")
                    .padding(start = 0.dp, end = 80.dp),
                contentDescription = null
            )


            Image(
                painter = painterResource(id = R.drawable.rubashka_kart),
                modifier = Modifier
                    .width(150.dp + 40.dp)
                    .height(270.dp)
                    .layoutId("IVthreeCard")
                    .padding(start = 0.dp, end = 40.dp),
                contentDescription = null
            )



            Image(
                painter = painterResource(id = R.drawable.rubashka_kart),
                modifier = Modifier
                    .width(150.dp)
                    .height(270.dp)
                    .layoutId("IVfoureCard")
                    .padding(start = 0.dp),
                contentDescription = null
            )



            Image(
                painter = painterResource(id = R.drawable.rubashka_kart),
                modifier = Modifier
                    .width(150.dp + 40.dp)
                    .height(270.dp)
                    .layoutId("IVfiveCard")
                    .padding(start = 40.dp),
                contentDescription = null
            )
        }
    }
}

    fun constraintVisibilityCard() = ConstraintSet {

        val IVoneCard = createRefFor("IVoneCard")
        val IVtwoCard = createRefFor("IVtwoCard")
        val IVthreeCard = createRefFor("IVthreeCard")
        val IVfoureCard = createRefFor("IVfoureCard")
        val IVfiveCard = createRefFor("IVfiveCard")

        val TextPalyer = createRefFor("TextPalyer")
        val IVfirstPirsonCard = createRefFor("FirstPirsonCard")
        val guideline = createGuidelineFromBottom(-0.08f)
        val guideCenterGorisantalLine = createGuidelineFromStart(0.5f)


        constrain(TextPalyer){
            end.linkTo(parent.end)
            start.linkTo(parent.start)
            top.linkTo(parent.top, margin = 30.dp)
        }







        constrain(IVoneCard) {
            bottom.linkTo(guideline)
            start.linkTo(guideCenterGorisantalLine)
            end.linkTo(guideCenterGorisantalLine)
        }

        constrain(IVfirstPirsonCard) {
            bottom.linkTo(guideline)
            start.linkTo(guideCenterGorisantalLine)
            end.linkTo(guideCenterGorisantalLine)
        }



        constrain(IVtwoCard) {
            bottom.linkTo(guideline)
            start.linkTo(guideCenterGorisantalLine)
            end.linkTo(guideCenterGorisantalLine)

        }
        constrain(IVthreeCard) {
            bottom.linkTo(guideline)
            start.linkTo(guideCenterGorisantalLine)
            end.linkTo(guideCenterGorisantalLine)

        }
        constrain(IVfoureCard) {
            bottom.linkTo(guideline)
            start.linkTo(guideCenterGorisantalLine)
            end.linkTo(guideCenterGorisantalLine)

        }
        constrain(IVfiveCard) {
            bottom.linkTo(guideline)
            start.linkTo(guideCenterGorisantalLine)
            end.linkTo(guideCenterGorisantalLine)

        }

    }


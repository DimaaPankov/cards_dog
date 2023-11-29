package com.fortunetiasasger.exampale.presentation.screens.screen_util.orientation_cards

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.fortunetiasasger.exampale.R
import com.fortunetiasasger.exampale.data.models.Person
import com.fortunetiasasger.exampale.data.repository.StaticDate
import com.fortunetiasasger.exampale.presentation.screens.screen_util.check_animation.model.OffSetX
import com.fortunetiasasger.exampale.presentation.screens.screen_util.check_animation.view.checkCardsAnimation
import com.fortunetiasasger.exampale.screens.setup_cards.com.fortunetiasasger.exampale.theme.fontFamaly
import kotlinx.coroutines.delay

@Composable
 fun Orientation_cards(person:Person,actionClickDrop:()->Unit) {

    var visibility by remember {
        mutableStateOf(true)
    }

    LaunchedEffect(true){
        delay(1000)
        visibility = false
    }

val cardsListNow = if(person == Person.ONE){
    StaticDate.listCardsPersonFirst
}else{
    StaticDate.listCardsPersonSecond

}

    ConstraintLayout(
        constraintSet = constraintsEight(),
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            modifier = Modifier
                .layoutId("IVmainCard")
                .fillMaxHeight(0.5f)
                .fillMaxWidth(0.8f)
                .alpha(0f),
            painter = painterResource(id = R.drawable.all_cards0),
            contentDescription = "logo",
        )

        if(cardsListNow.size >= 1) {
            checkCardsAnimation(
                img = StaticDate.listCardsNow()[0],
                layoutId = "IVoneCard",
                person = person,
                ofSetXDefault = OffSetX.one,
                actionDrop = actionClickDrop
            )
        }

        if(cardsListNow.size >= 2) {
            checkCardsAnimation(
                StaticDate.listCardsNow()[1],
                layoutId = "IVtwoCard",
                person = person,
                ofSetXDefault = OffSetX.two,
                actionDrop = actionClickDrop
            )
        }

        if(cardsListNow.size >= 3) {
            checkCardsAnimation(
                StaticDate.listCardsNow()[2],
                layoutId = "IVthreeCard",
                person = person,
                ofSetXDefault = OffSetX.three,
                actionDrop = actionClickDrop
            )
        }

        if(cardsListNow.size >= 4) {
            checkCardsAnimation(
                StaticDate.listCardsNow()[3],
                layoutId = "IVfoureCard",
                person = person,
                ofSetXDefault = OffSetX.foure,
                actionDrop = actionClickDrop
            )
        }

        if(cardsListNow.size >= 5) {
            checkCardsAnimation(
                StaticDate.listCardsNow()[4],
                layoutId = "IVfiveCard",
                person = person,
                ofSetXDefault = OffSetX.five,
                actionDrop = actionClickDrop
            )
        }

        if(cardsListNow.size >= 6) {
            checkCardsAnimation(
                StaticDate.listCardsNow()[5],
                layoutId = "IVsixCard",
                person = person,
                ofSetXDefault = OffSetX.six,
                actionDrop = actionClickDrop
            )
        }


        Text(
            text = "First persone 's move",
            modifier = Modifier
                .fillMaxWidth (0.8f)
                .layoutId("TextPalyer")
                .focusable(), textAlign = TextAlign.Center,
            fontSize = 30.sp,
            color = Color.White,
            fontFamily = fontFamaly
        )
    }


    AnimatedVisibility(
        visible = visibility,
        modifier = Modifier
            .fillMaxSize()


    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

            Image(
                painter = painterResource(id = R.drawable.img_3),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )

            Text(
                text = "First persone 's move",
                modifier = Modifier
                    .fillMaxWidth (0.8f),
                textAlign = TextAlign.Center,
                fontSize = 30.sp,
                color = Color.White,
                fontFamily = fontFamaly
            )

        }
    }
}

fun constraintsEight() = ConstraintSet {
    val IVshowCard = createRefFor("IVmainCard")
    val IVoneCard = createRefFor("IVoneCard")
    val IVtwoCard = createRefFor("IVtwoCard")
    val IVthreeCard = createRefFor("IVthreeCard")
    val IVfoureCard = createRefFor("IVfoureCard")
    val IVfiveCard = createRefFor("IVfiveCard")
    val IVsixCard = createRefFor("IVsixCard")
    val TextPalyer = createRefFor("TextPalyer")
    val guideline = createGuidelineFromBottom(-0.1f)
    val guideCenterGorisantalLine = createGuidelineFromStart(0.5f)


    constrain(TextPalyer){
        end.linkTo(parent.end)
        start.linkTo(parent.start)
        top.linkTo(parent.top, margin = 30.dp)
    }

    constrain(IVshowCard) {
        top.linkTo(parent.top, margin = 60.dp)
        end.linkTo(parent.end)
        start.linkTo(parent.start)
    }





    constrain(IVoneCard) {
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
    constrain(IVsixCard) {
        bottom.linkTo(guideline)
        start.linkTo(guideCenterGorisantalLine)
        end.linkTo(guideCenterGorisantalLine)
    }

}
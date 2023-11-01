package com.fortunetiasasger.exampale.presentation.screens.gamepersonsecond.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.draw.rotate

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
import com.fortunetiasasger.exampale.screens.setup_cards.com.fortunetiasasger.exampale.theme.Cards_spels_plus_composeTheme
import com.fortunetiasasger.exampale.screens.setup_cards.com.fortunetiasasger.exampale.theme.fontFamaly
import kotlinx.coroutines.delay

@Preview(showBackground = true)
@Composable
private fun ShowScreenGame() {
    Cards_spels_plus_composeTheme {
        ScreenGamePersonSecond.ShowScreen()
    }
}

object ScreenGamePersonSecond {
    @Composable
    fun ShowScreen(
    ) {

        var visibility by remember {
            mutableStateOf(true)
        }

        LaunchedEffect(true){
            delay(1000)
            visibility = false
        }

            Image(
            painter = painterResource(id = R.drawable.background),
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop,
            contentDescription = "back"
        )






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


            checkCardsAnimation(
                R.drawable.all_cards0,
                layoutId = "IVoneCard",
                width = 150,
                height = 270,
                paddingStart = Padding.startOne,
                paddingEnd = Padding.endOne,
                paddingStartDefault = 0,
                paddingEndDefault = 120
            )

            Image(
                modifier = Modifier
                    .width(240.dp)
                    .height(655.dp)
                    .padding(bottom = 375.dp)
                    .rotate(10f)
                    .layoutId("FirstPirsonCard"),
                painter = painterResource(id = R.drawable.rubashka_kart),
                   contentDescription = null
            )

            checkCardsAnimation(
                R.drawable.all_cards0,
                layoutId = "IVtwoCard",
                width = 150,
                height = 270,
                paddingStart = Padding.startTwo,
                paddingEnd = Padding.endTwo,
                paddingStartDefault = 0,
                paddingEndDefault = 80
            )


            checkCardsAnimation(
                R.drawable.all_cards0,
                layoutId = "IVthreeCard",
                width = 150,
                height = 270,
                paddingStart = Padding.startThree,
                paddingEnd = Padding.endThree,
                paddingStartDefault = 0,
                paddingEndDefault = 40
            )


            checkCardsAnimation(
                R.drawable.all_cards0,
                layoutId = "IVfoureCard",
                width = 150,
                height = 270,
                paddingStart = Padding.startFoure,
                paddingEnd = Padding.endFoure,
                paddingStartDefault = 0,
                paddingEndDefault = 0
            )

            checkCardsAnimation(
                R.drawable.all_cards0,
                layoutId = "IVfiveCard",
                width = 150,
                height = 270,
                paddingStart = Padding.startFive,
                paddingEnd = Padding.endFive,
                paddingStartDefault = 40,
                paddingEndDefault = 0
            )

            checkCardsAnimation(
                R.drawable.all_cards0,
                layoutId = "IVsixCard",
                width = 150,
                height = 270,
                paddingStart = Padding.startSix,
                paddingEnd = Padding.endSix,
                paddingStartDefault = 80,
                paddingEndDefault = 0
            )

            Text(
                text = "Second persone 's move",
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
            visible = false,
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
                    text = "Second persone 's move",
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
val IVfirstPirsonCard = createRefFor("FirstPirsonCard")
val guideline = createGuidelineFromBottom(-0.08f)
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
constrain(IVsixCard) {
bottom.linkTo(guideline)
    start.linkTo(guideCenterGorisantalLine)
    end.linkTo(guideCenterGorisantalLine)
}


}



}

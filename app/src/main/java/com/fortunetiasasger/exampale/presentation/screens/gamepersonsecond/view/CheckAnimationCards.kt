package com.fortunetiasasger.exampale.presentation.screens.gamepersonsecond.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
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
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fortunetiasasger.exampale.R
import com.fortunetiasasger.exampale.presentation.activity.MainActivity
import com.fortunetiasasger.exampale.presentation.nav.Screen
import com.fortunetiasasger.exampale.presentation.screens.gamepersonfirst.view.Padding
import kotlinx.coroutines.delay



@Composable
fun checkCardsAnimation(
    img:Int,
    layoutId:String,
    paddingStartDefault: Int,
    paddingEndDefault: Int,
    paddingStart:Int,
    paddingEnd:Int,
    height:Int,
    width:Int
) {
    var animated by remember { mutableStateOf(false) }
    var _img by remember { mutableStateOf(R.drawable.rubashka_kart) }
    val rotation = remember { Animatable(initialValue = 360f) }

    var clickedDrop by remember {
        mutableStateOf(false)
    }

    val alpha by animateIntAsState(
        targetValue = if (clickedDrop) 0 else 1,
    )

    val rotationDrop by animateIntAsState(
        targetValue = if (clickedDrop) 10 else 0,
    )


    val animatedPaddingStart by animateIntAsState (
        targetValue = if (clickedDrop) paddingStart else 0
    )

    val animatedSizeCard by animateIntAsState (
        targetValue = if (clickedDrop) 100 else 0
    )
    if (clickedDrop) {
        LaunchedEffect(animated) {
            rotation.animateTo(
                targetValue = 180f,
                animationSpec = tween(durationMillis = 500),
            )
        }
        LaunchedEffect(true) {
            delay(160L)
            _img = R.drawable.rubashka_kart
            delay(550)
            MainActivity.navController.navigate(Screen.ScreenGamePirsonFirst.route)
        }
    }

    val animatedPaddingEnd by animateIntAsState (
        targetValue = if (clickedDrop) paddingEnd else 0,

        )

    val animatedPaddingDrop by animateIntAsState(
        targetValue = if (clickedDrop) 125 else 0,
    )

    val animatedPaddingBottom by animateIntAsState(
        targetValue = if (animated) 250 else 0,
        animationSpec = tween(
            durationMillis = 500
        )
    )


    if (animated) {
        LaunchedEffect(true) {
            delay(160L)
            _img = img
        }
    } else {
        LaunchedEffect(true) {
            delay(160L)
            _img = R.drawable.rubashka_kart
        }
    }

    LaunchedEffect(animated) {
        rotation.animateTo(
            targetValue = if (animated) 0f else 180f,
            animationSpec = tween(durationMillis = 500),
        )

    }
    Box(
        modifier = Modifier
            .height(height.dp + animatedPaddingBottom.dp + animatedPaddingDrop.dp+ animatedSizeCard.dp)
            .rotate(0f)
            .width(width.dp +animatedPaddingStart.dp+animatedPaddingEnd.dp+paddingStartDefault.dp + paddingEndDefault.dp+ animatedSizeCard.dp)
            .layoutId(layoutId)
            .padding(bottom = animatedPaddingBottom.dp + animatedPaddingDrop.dp,
                start = animatedPaddingStart.dp+paddingStartDefault.dp,
                end = animatedPaddingEnd.dp + paddingEndDefault.dp
            )
            .graphicsLayer {
                rotationY = rotation.value
            }
    ) {
        Image(
            modifier = Modifier
                .height(height.dp + animatedSizeCard.dp)
                .rotate(rotationDrop.toFloat())
                .width(width.dp + animatedSizeCard.dp)
                .clickable {
                    animated = !animated
                },
            painter = painterResource(id = _img),
            contentDescription = "",
        )

        AnimatedVisibility(
            visible = animated,
            modifier = Modifier
                .fillMaxSize()


        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 10.dp, end = 10.dp),
                contentAlignment = Alignment.BottomCenter,

                ) {
                Image(
                    painter = painterResource(id = R.drawable.drop),
                    contentDescription = null,
                    modifier = Modifier
                        .wrapContentSize()
                        .alpha(alpha.toFloat())
                        .clickable {
                            clickedDrop = true
                        }

                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewrotaionAnimaton(){

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        checkCardsAnimation(
            img = R.drawable.all_cards1,
            layoutId = "IVfiveCard",
            width = 100,
            height = 180,
            paddingStart = Padding.endFoure,
            paddingEnd = Padding.endFoure,
            paddingStartDefault = 40,
            paddingEndDefault = 0
        )
    }
}
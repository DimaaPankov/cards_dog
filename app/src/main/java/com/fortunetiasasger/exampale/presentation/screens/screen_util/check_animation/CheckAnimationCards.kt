package com.fortunetiasasger.exampale.presentation.screens.screen_util.check_animation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.rotationMatrix
import com.fortunetiasasger.exampale.R
import kotlinx.coroutines.delay


@Composable
fun checkCardsAnimation(
    img:Int,
    layoutId:String,
    ofSetXDefault: Int,
    rotationCard:Int,
    actionDrop:()->Unit
) {

    val DEFAULT_WIDTH = 150
    val DEFAULT_HEIGHT = 270
    val ANIMATE_WIDTH = 225
    val ANIMATE_HEIGHT = 305
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp

    val animDropY = (screenHeight-(DEFAULT_HEIGHT/2))/-2
    val animCheckY = -(DEFAULT_HEIGHT+10)


 //   var animated by remember { mutableStateOf(false) }
    var _img by remember { mutableStateOf(R.drawable.rubashka_kart) }
    val rotation = remember { Animatable(initialValue = 360f) }

    var click by remember {
        mutableStateOf(ClickedCard.DON_T_CLICKED)
    }

    val alpha by animateIntAsState(
        targetValue = when(click){
            ClickedCard.DON_T_CLICKED ->0
            ClickedCard.CHECK_CLICKED -> 1
            ClickedCard.DROP_CLICKED ->1
        }
    )

    val offSetY = animateIntAsState(
        when(click){
            ClickedCard.DON_T_CLICKED ->0
            ClickedCard.CHECK_CLICKED -> animCheckY
            ClickedCard.DROP_CLICKED -> animDropY
        }
    )

    val offSetX = animateIntAsState(
        when(click){
            ClickedCard.DON_T_CLICKED -> ofSetXDefault
            ClickedCard.CHECK_CLICKED -> ofSetXDefault
            ClickedCard.DROP_CLICKED -> 0
        }
    )

    val height = animateIntAsState(
        when(click){
            ClickedCard.DON_T_CLICKED -> DEFAULT_HEIGHT
            ClickedCard.CHECK_CLICKED -> DEFAULT_HEIGHT
            ClickedCard.DROP_CLICKED ->  ANIMATE_HEIGHT
        }
    )


    val widht = animateIntAsState(
        when(click){
            ClickedCard.DON_T_CLICKED -> DEFAULT_WIDTH
            ClickedCard.CHECK_CLICKED -> DEFAULT_WIDTH
            ClickedCard.DROP_CLICKED ->  ANIMATE_WIDTH
        }
    )

    if(click == ClickedCard.DROP_CLICKED){
        LaunchedEffect(true) {
            delay(660L)
            actionDrop()
        }

    }

    val rotationDrop by animateIntAsState(
        targetValue = when(click){
            ClickedCard.DON_T_CLICKED ->0
            ClickedCard.CHECK_CLICKED -> 0
            ClickedCard.DROP_CLICKED ->-rotationCard
        }
    )

    if (click == ClickedCard.CHECK_CLICKED) {
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
    if (click == ClickedCard.CHECK_CLICKED) {
        LaunchedEffect(true) {
            rotation.animateTo(
                targetValue = 180f,
                animationSpec = tween(durationMillis = 500),
            )
        }
    }else{
        LaunchedEffect(true) {
            rotation.animateTo(
                targetValue = 0f,
                animationSpec = tween(durationMillis = 500),
            )
        }
    }

Box(
    modifier = Modifier
        .height(height.value.dp)
        .rotate(0f)
        .width(widht.value.dp)
        .layoutId(layoutId)
        .offset(x = offSetX.value.dp, y = offSetY.value.dp)
        .graphicsLayer {
            rotationY = rotation.value
        }
) {
    Image(
        modifier = Modifier
            .height(height.value.dp)
            .rotate(rotationDrop.toFloat())
            .width(widht.value.dp)
            .clickable {
                click = if(click == ClickedCard.CHECK_CLICKED){
                    ClickedCard.DON_T_CLICKED
                }else{
                    ClickedCard.CHECK_CLICKED
                }
            },
        painter = painterResource(id = _img),
        contentDescription = "",
    )

    AnimatedVisibility(
        visible = when(click){
            ClickedCard.DON_T_CLICKED ->false
            ClickedCard.CHECK_CLICKED ->true
            ClickedCard.DROP_CLICKED ->false
        },
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
                        click = ClickedCard.DROP_CLICKED
                    }

            )
        }
    }
}
}

private enum class ClickedCard{
    DON_T_CLICKED,CHECK_CLICKED,DROP_CLICKED
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
            rotationCard = -10,
            ofSetXDefault = OffSetX.one,
            actionDrop = {}
        )
    }
}














/*

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

    val DEFAULT_WIDTH = 100
    val DEFAULT_HEIGHT = 180

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
        targetValue = if (clickedDrop) -10 else 0,
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
                MainActivity.navController.navigate(Screen.ScreenGamePirsonSecond.route)
}
    }

    val animatedPaddingEnd by animateIntAsState (
        targetValue = if (clickedDrop) paddingEnd else 0,

    )

  val animatedPaddingDrop by animateIntAsState(
      targetValue = if (clickedDrop) 50 else 0,
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
            paddingStart = OffSetX.endFoure,
            paddingEnd = OffSetX.endFoure,
            paddingStartDefault = 40,
            paddingEndDefault = 0
        )
    }
}
 */


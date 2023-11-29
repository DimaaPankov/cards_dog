package com.fortunetiasasger.exampale.presentation.screens.winning_a_move.usecases

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
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
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fortunetiasasger.exampale.R
import com.fortunetiasasger.exampale.data.models.Person
import com.fortunetiasasger.exampale.data.repository.StaticDate
import com.fortunetiasasger.exampale.screens.setup_cards.com.fortunetiasasger.exampale.theme.fontFamaly
import kotlinx.coroutines.delay

@Preview
@Composable
fun AnimationWinPreview(){
    AnimationWin(
        R.drawable.all_card_23,
                R.drawable.all_card_23,
        winPerson = Person.BOTH
    )
}

@Composable
fun AnimationWin(

    cardPersonOne:Int,
    cardPersonTwo:Int,
    winPerson:Person
                           ) {

    val Y_ANIMATE = 150
    val DURATION_MILLS = 1500

    val DEFAULT_WEIDHT_FIRST = 240
    val DEFAULT_HEIGHT_FIRST = 280
    val ANIMATE_WEIDHT_FIRST = 380
    val ANIMATE_HEIGHT_FIRST = 420
    val DEFAULT_Y_FIRST = 0
    val ANIMATE_Y_FIRST = DEFAULT_Y_FIRST + Y_ANIMATE
    val DEFAULT_ROTATIAN_FIRST = -10f
    val ANIMATE_ROTATIAN_FIRST = 0f
    val DEFAULT_FLOATE_FIRST = 1f
    val ANIMATE_FLOATE_FIRST = 0f


    val DEFAULT_WEIDHT_SECOND = 240
    val DEFAULT_HEIGHT_SECOND = 280
    val ANIMATE_WEIDHT_SECOND = 360
    val ANIMATE_HEIGHT_SECOND = 420
    val DEFAULT_Y_SECOND = 0
    val ANIMATE_Y_SECOND = DEFAULT_Y_SECOND - Y_ANIMATE
    val DEFAULT_ROTATIAN_SECOND = 10f
    val ANIMATE_ROTATIAN_SECOND = 0f
    val DEFAULT_FLOATE_SECOND = 1f
    val ANIMATE_FLOATE_SECOND = 0f

    val DEFAULT_ALPHA_TEXT_WIN = 0f
    val ANIMATE_ALPHA_TEXT_WIN = 1f

    var img_person_first by remember { mutableStateOf(cardPersonOne) }
    var img_person_second by remember { mutableStateOf(cardPersonTwo) }


    var startAnimation by remember {
        mutableStateOf(false)
    }


   var rotationState by remember {
        mutableStateOf(false)
    }

    var imgPersonFirstState by remember {
        mutableStateOf(false)
    }
    var imgPersonSecondState by remember {
        mutableStateOf(false)
    }
    var rotationFirstState by remember {
        mutableStateOf(false)
    }
    var rotationSecondState by remember {
        mutableStateOf(false)
    }
    var yFirstState by remember {
        mutableStateOf(false)
    }
    var ySecondState by remember {
        mutableStateOf(false)
    }
    var alphaFirstState by remember {
        mutableStateOf(true)
    }

    var alphaSecondState by remember {
        mutableStateOf(true)
    }

    var weightFirstState by remember {
        mutableStateOf(false)
    }

    var heightFirstState by remember {
        mutableStateOf(false)
    }

    var weightSecondState by remember {
        mutableStateOf(false)
    }

    var heightSecondState by remember {
        mutableStateOf(false)
    }
    var textWinState by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(true) {
        delay(400)
        startAnimation = true
        imgPersonFirstState = true
        imgPersonSecondState = true
        rotationFirstState = true
        rotationSecondState = true
        yFirstState = true
        ySecondState = true
    }

    LaunchedEffect(true) {
        delay(2000)
       rotationState = true


        delay(900)
        when(winPerson){
            Person.ONE -> {yFirstState = false;alphaSecondState = false;
                           weightFirstState = true;heightFirstState = true }
            Person.TWO -> {ySecondState = false;alphaFirstState = false
                           weightSecondState = true;heightSecondState = true}
            Person.BOTH -> {
            }
        }
        delay(200)
        textWinState = true


    }

    val textWinAlpha by animateFloatAsState(
        targetValue = if (textWinState) ANIMATE_ALPHA_TEXT_WIN  else DEFAULT_ALPHA_TEXT_WIN,
        animationSpec = tween(
            durationMillis = DURATION_MILLS
        )
    )

    val weightFirst by animateIntAsState(
        targetValue = if (weightFirstState) ANIMATE_WEIDHT_FIRST  else DEFAULT_WEIDHT_FIRST ,
        animationSpec = tween(
            durationMillis = DURATION_MILLS
        )
    )

    val heightFirst by animateIntAsState(
        targetValue = if (heightFirstState) ANIMATE_HEIGHT_FIRST  else DEFAULT_HEIGHT_FIRST ,
        animationSpec = tween(
            durationMillis = DURATION_MILLS
        )
    )

    val weightSecond by animateIntAsState(
        targetValue = if (weightSecondState)  ANIMATE_WEIDHT_SECOND else DEFAULT_WEIDHT_SECOND ,
        animationSpec = tween(
            durationMillis = DURATION_MILLS
        )
    )

    val heightSecond by animateIntAsState(
        targetValue = if (heightSecondState)  ANIMATE_HEIGHT_SECOND else DEFAULT_HEIGHT_SECOND ,
        animationSpec = tween(
            durationMillis = DURATION_MILLS
        )
    )

    val ySecond by animateIntAsState(
        targetValue = if (ySecondState)  ANIMATE_Y_SECOND else DEFAULT_Y_SECOND ,
        animationSpec = tween(
            durationMillis = DURATION_MILLS
        )
    )

   val alphaFirst by animateFloatAsState(
    targetValue = if (alphaFirstState) DEFAULT_FLOATE_FIRST else ANIMATE_FLOATE_FIRST ,
    animationSpec = tween(durationMillis = DURATION_MILLS)
    )

    val alphaSecond by animateFloatAsState(
        targetValue = if (alphaSecondState) DEFAULT_FLOATE_SECOND else ANIMATE_FLOATE_SECOND ,
        animationSpec = tween(durationMillis = DURATION_MILLS)
    )

    val yFirst by animateIntAsState(
        targetValue = if (yFirstState) ANIMATE_Y_FIRST else  DEFAULT_Y_FIRST,
        animationSpec = tween(
            durationMillis = DURATION_MILLS
        )
    )

    val roatationFirst by animateFloatAsState(
        targetValue = if (rotationFirstState) ANIMATE_ROTATIAN_FIRST else  DEFAULT_ROTATIAN_FIRST,
        animationSpec = tween(
            durationMillis = DURATION_MILLS
        )
    )

    val rotationSecond by animateFloatAsState(
        targetValue = if (rotationSecondState) ANIMATE_ROTATIAN_SECOND else  DEFAULT_ROTATIAN_SECOND,
        animationSpec = tween(
            durationMillis = DURATION_MILLS
        )
    )




    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize(1f)
    ) {
        val imagePersonFirst = @Composable{
                width:Int,
                height:Int,
                y:Int, -> Image(
            painter = painterResource(id = img_person_first),
            modifier = Modifier
                .width(width.dp)
                .height(height.dp)
                .alpha(alphaFirst)
                .rotate(roatationFirst)
                .offset(
                    y = y.dp
                )
                .graphicsLayer {
                    rotationY =0f
                },
            contentDescription = null
        )}

      val imagePersonSecond = @Composable{
              width:Int,
              height:Int,
              y:Int -> Image(
            painter = painterResource(id = img_person_second),
            modifier = Modifier
                .width(width.dp)
                .height(height.dp)
                .alpha(alphaSecond)
                .rotate(rotationSecond)
                .offset(
                    y = y.dp
                )
                .graphicsLayer {
                    rotationY = 0f
                }
            ,
            contentDescription = null
        )}

        imagePersonFirst(
            weightFirst,
            heightFirst,
            yFirst)

        imagePersonSecond(
            weightSecond,
            heightSecond,
            ySecond
        )

        if(true){
           Box(
               modifier = Modifier.fillMaxSize(),
               contentAlignment = Alignment.BottomCenter
           ){
               Text(
                    text = when(winPerson) {
                        Person.ONE -> StaticDate.nameFirst+" win!"
                        Person.TWO ->"Person two\n win!"
                        Person.BOTH -> "Draw"
                    },
                   fontFamily = fontFamaly,
                   fontSize = 41.sp,
                   color = Color.White,
                   textAlign = TextAlign.Center,
                   modifier = Modifier
                       .wrapContentSize()
                       .alpha(textWinAlpha)
                       .padding(bottom = 40.dp)
                            )
                    }
           }
    }
}




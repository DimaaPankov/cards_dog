package com.fortunetiasasger.exampale.lesson.animation

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fortunetiasasger.exampale.R
import kotlinx.coroutines.delay


@Composable
fun checkCardsAnimation(img:Int) {
    var animated by remember { mutableStateOf(false) }
    var img by remember { mutableStateOf(R.drawable.rubashka_kart) }
    val rotation = remember { Animatable(initialValue = 360f) }
    val padding by animateIntAsState(
        targetValue = if (animated) 250 else 0,
        animationSpec = tween(
            durationMillis = 500
        )
    )


    if (animated) {
        LaunchedEffect(true) {
            delay(160L)
            img = R.drawable.img
        }
    } else {
        LaunchedEffect(true) {
            delay(160L)
            img = R.drawable.rubashka_kart
        }
    }

    LaunchedEffect(animated) {
        rotation.animateTo(
            targetValue = if (animated) 0f else 180f,
            animationSpec = tween(durationMillis = 500),
        )

    }

        Image(
            modifier = Modifier
                .graphicsLayer {
                    rotationY = rotation.value
                }
                .height(200.dp + padding.dp)
                .width(100.dp)
                .padding(bottom = padding.dp)
                .clickable {
                    animated = !animated
                },
            painter = painterResource(id = img),
            contentDescription = "",
        )
    
}

@Preview
@Composable
fun PreviewrotaionAnimaton(){
    checkCardsAnimation(R.drawable.all_cards1)
}
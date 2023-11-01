package com.fortunetiasasger.exampale.lesson.swipe.l1


import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.AnchoredDraggableState
import androidx.compose.foundation.gestures.DraggableAnchors
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.anchoredDraggable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset

import androidx.compose.ui.unit.dp
import com.fortunetiasasger.exampale.R
import kotlin.math.roundToInt



@Composable
fun ShowDragle(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
        // Этот код создает Composable, который будет отображать перетаскиваемое содержимое.
        Box {
            HorizontalDraggableSample(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 80.dp)
            )
            VerticalDraggableSample(
                modifier = Modifier
                    .fillMaxHeight()
                    .align(Alignment.Center)
            )
        }
    }
}

enum class DragAnchors(val fraction: Float) {
    Start(0f),
    OneQuarter(.2f),
    Half(.4f),
    ThreeQuarters(.6f),
    End(8f),
    EndPlus(1f)
}




@Composable
fun DraggableContent(
    modifier: Modifier = Modifier,
) {
    Image(
        painter = painterResource(id = R.drawable.go),
        modifier = modifier,
        contentDescription = null,
    )
}



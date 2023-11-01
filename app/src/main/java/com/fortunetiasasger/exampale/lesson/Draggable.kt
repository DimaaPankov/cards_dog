package com.fortunetiasasger.exampale.lesson


import androidx.compose.foundation.gestures.DraggableAnchors

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp

/*
@Composable
 fun DraggableText() {
    var offsetY by remember { mutableStateOf(0f) }
    var textCount by remember { mutableStateOf(0f) }

    Box(
        modifier = Modifier
            // fillMaxWidth(1f)
            .width(120.dp)
            .height(200.dp)
            .background(Color.Red)
            // .offset { IntOffset(offsetX.roundToInt(), 0) }
            .draggable(
                orientation = Orientation.Horizontal,
                state = rememberDraggableState { delta ->
                    offsetY += delta
                    var i = true
                  if(delta.toInt() >= 5) {
                      if (i) {
                          i = false
                          ++textCount
                      }
                  }

                    Log.d("test_1", offsetY.toString())
                    Log.d(
                        "test_2",
                        delta
                            .toInt()
                            .toString()
                    )

                }
            ),
     //  text = "Drag me!"
    )

    Box(
        modifier = Modifier.fillMaxSize()
        ,contentAlignment = Alignment.Center
    ){
       Text(
           text = textCount.toString()
           ,
           )
    }
}*/



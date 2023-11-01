package com.fortunetiasasger.exampale.lesson

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import kotlin.random.Random

class State {
}

@Preview
@Composable
fun Show(){
    ColorBox(Modifier.fillMaxSize())
}

@Composable
fun ColorBox(modifier:Modifier = Modifier){
    val color =   remember {
        mutableStateOf(Color.Yellow)
        }

    Box(modifier = modifier
        .background(color.value)
        .clickable{
            color.value = Color(
                Random.nextFloat(),
                Random.nextFloat(),
                Random.nextFloat()
                ,1f
            )
        }
    )
}
package com.fortunetiasasger.exampale.lesson.swipe.l2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun HelloWorldCard() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray), contentAlignment = Alignment.Center
    ) {
        Text(text = "Hello World!!")
    }
}

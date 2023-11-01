package com.fortunetiasasger.exampale.lesson.mvvm.l3.navigationlesson

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

class ScreenTwo {

    @Composable
    fun ScreenTwo(deteil:String) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
            ) {
                     Text(text = deteil)
        }
    }}

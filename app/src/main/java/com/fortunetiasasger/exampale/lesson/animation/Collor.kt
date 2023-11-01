package com.fortunetiasasger.exampale.lesson.animation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fortunetiasasger.exampale.screens.setup_cards.com.fortunetiasasger.exampale.theme.Green300
import com.fortunetiasasger.exampale.screens.setup_cards.com.fortunetiasasger.exampale.theme.Purple100

@Composable
@Preview(showBackground = true)
fun showCollor(){
    Collor()
}

@Composable
fun Collor(){
    var tabCollor by remember { mutableStateOf(true) }
    val backgroundColor = if (tabCollor) Purple100 else Green300

    Column(
        modifier = Modifier.fillMaxSize()
    ){


        Button(onClick = {
            tabCollor = !tabCollor
        }) {
            Text(text="Toggle")
        }
            Box(
                modifier = Modifier
                    .background(backgroundColor)
                    .size(200.dp)

            )
    }
}

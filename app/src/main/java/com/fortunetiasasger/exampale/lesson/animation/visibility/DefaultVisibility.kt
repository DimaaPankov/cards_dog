package com.fortunetiasasger.exampale.lesson.animation.visibility

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Preview(showBackground = true)
fun showVisibility(){
    DefaultVisibility()
}

@Composable
fun DefaultVisibility(){

    Column(
        modifier = Modifier.fillMaxSize()
    ){

        var isVisibale: Boolean by remember {
            mutableStateOf(false)
        }

        var isRound by remember{
            mutableStateOf(false)
        }

        Button(onClick = {
            isVisibale=!isVisibale
            isRound = !isRound
            Log.d("test_2",isRound.toString())
        }) {
            Text(text="Toggle")
        }


         AnimatedVisibility(
         visible = !isVisibale,
         modifier = Modifier
             .fillMaxSize()
             .weight(1f)

        ) {
        Box(modifier = Modifier.background(Color.Red))
        }

    }
}
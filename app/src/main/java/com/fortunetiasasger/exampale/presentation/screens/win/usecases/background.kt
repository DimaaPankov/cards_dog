package com.fortunetiasasger.exampale.presentation.screens.win.usecases

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.fortunetiasasger.exampale.R

@Composable
fun backgroundWin(){
    Image(
        painter = painterResource(id = R.drawable.background),
        modifier = Modifier
            .fillMaxSize(),
        contentScale = ContentScale.Crop,
        contentDescription = "back"
    )
}
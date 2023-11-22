package com.fortunetiasasger.exampale.presentation.screens.game_person_first.usecase

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.fortunetiasasger.exampale.R

@Composable
fun Background_First(){
    Image(
        painter = painterResource(id = R.drawable.background),
        modifier = Modifier
            .fillMaxSize(),
        contentScale = ContentScale.Crop,
        contentDescription = null
    )
}
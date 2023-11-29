package com.fortunetiasasger.exampale.presentation.screens.game_person_second.use_case

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fortunetiasasger.exampale.R
import com.fortunetiasasger.exampale.data.models.Person
import com.fortunetiasasger.exampale.data.repository.StaticDate

@Composable
@Preview
fun PreviewBackgroundSecond(){
    Background_second()
}


@Composable
fun Background_second(){
    Image(
        painter = painterResource(id = R.drawable.background),
        modifier = Modifier
            .fillMaxSize(),
        contentScale = ContentScale.Crop,
        contentDescription = null
    )

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Image(
            painter = painterResource(id =
                StaticDate.cardImgDropedPersonFirst
            ),
            modifier = Modifier
                .width(225.dp)
                .height(305.dp)
                .rotate(-10f),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
    }
}
package com.fortunetiasasger.exampale.presentation.screens.loading.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.fortunetiasasger.exampale.R
import com.fortunetiasasger.exampale.presentation.activity.MainActivity
import com.fortunetiasasger.exampale.presentation.nav.Screen
import com.fortunetiasasger.exampale.presentation.screens.loading.viewmodel.ViewModelLoading
import com.fortunetiasasger.exampale.presentation.screens.winning_game.viewmodel.ViewModelWinningGame
import com.fortunetiasasger.exampale.screens.setup_cards.com.fortunetiasasger.exampale.theme.Cards_spels_plus_composeTheme
import kotlinx.coroutines.delay


@Preview
@Composable
fun ShowLoading(){
    ScreenLoading.ShowScreen()
}


object ScreenLoading {

    val viewModel = ViewModelWinningGame()
    @Composable
    fun ShowScreen() {


        SetDefaultView()
    }



    @Composable
    fun SetDefaultView() {

        viewModel.goOtherScreen()

        Box(
            modifier = Modifier.fillMaxSize()
            ,contentAlignment = Alignment.Center
        ) {
            Image(
                contentScale = ContentScale.Crop,
                painter = painterResource(id = R.drawable.background),
                contentDescription = "backGround"
            )

            Column(
                modifier = Modifier
                    .fillMaxHeight(0.5f)
                    .fillMaxWidth(0.5f),
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxHeight(0.5f)
                        .fillMaxWidth(),
                    painter = painterResource(id = R.drawable.logo_main),
                    contentDescription = "logo",
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .fillMaxSize(0.3f), color = Color.White
                    )
                }
            }
        }
    }



    }

@Preview
@Composable
fun GreetingPrevie2w() {
    Cards_spels_plus_composeTheme {
        ScreenLoading.ShowScreen()
    }
}

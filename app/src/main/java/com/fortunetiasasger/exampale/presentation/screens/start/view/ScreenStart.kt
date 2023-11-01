package com.fortunetiasasger.exampale.presentation.screens.start.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.fortunetiasasger.exampale.R
import com.fortunetiasasger.exampale.presentation.activity.MainActivity
import com.fortunetiasasger.exampale.presentation.nav.Screen
import com.fortunetiasasger.exampale.presentation.screens.start.viewmodel.ViewModelStart
import com.fortunetiasasger.exampale.screens.setup_cards.com.fortunetiasasger.exampale.theme.Cards_spels_plus_composeTheme


object ScreenStart {
    @Composable
    fun ShowScreen() {

        val viewModel  = ViewModelStart()
        val clickedStartState = viewModel.isClickedStartState.observeAsState(initial = false).value

        if(clickedStartState){
            MainActivity.navController.navigate(Screen.ScreenPlayers.route)
        }

        Image(
            painter = painterResource(id = R.drawable.background),
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop,
            contentDescription = "back"
        )

        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier
                    .fillMaxHeight(0.5f)
                    .fillMaxWidth(0.8f)
                    .clickable { MainActivity.navController.navigate(Screen.ScreenChooseStones.route) },
                painter = painterResource(id = R.drawable.logo_main),
                contentDescription = "logo",

            )
        }


        val constraints = ConstraintSet {
            val IVclickStart = createRefFor("IVclickStart")

            constrain(IVclickStart) {
                bottom.linkTo(parent.bottom, margin = 26.dp)

                end.linkTo(parent.end)
                start.linkTo(parent.start)


            }


        }

        ConstraintLayout(
            constraintSet = constraints,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                modifier = Modifier
                    .layoutId("IVclickStart")
                    .fillMaxWidth(0.9f)
                    .fillMaxHeight(0.1f)
                    .clickable {
                               viewModel.isClickedStartState(true)
                    },
                painter = painterResource(id = R.drawable.click_to_start),
                contentDescription = ""
            )


        }
    }
}

    @Preview(showBackground = true)
    @Composable
    fun vieStart() {
        Cards_spels_plus_composeTheme {
            ScreenStart.ShowScreen()
        }
    }




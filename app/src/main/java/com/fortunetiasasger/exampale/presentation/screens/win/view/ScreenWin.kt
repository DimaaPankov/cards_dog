package com.fortunetiasasger.exampale.presentation.screens.win.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import com.fortunetiasasger.exampale.R
import com.fortunetiasasger.exampale.data.models.Person
import com.fortunetiasasger.exampale.presentation.activity.MainActivity
import com.fortunetiasasger.exampale.presentation.nav.Screen
import com.fortunetiasasger.exampale.presentation.screens.win.usecases.AnimationWin
import com.fortunetiasasger.exampale.presentation.screens.win.usecases.animateInvisibilityBottomCard
import com.fortunetiasasger.exampale.presentation.screens.win.usecases.backgroundWin
import com.fortunetiasasger.exampale.screens.setup_cards.com.fortunetiasasger.exampale.theme.Cards_spels_plus_composeTheme
import kotlinx.coroutines.delay


@Preview(showBackground = true)
@Composable
private fun ShowScreenGame() {
    Cards_spels_plus_composeTheme {
        ScreenWin.ShowScreen()
    }
}

object ScreenWin {
    @Composable
    fun ShowScreen(
    ) {
        backgroundWin()
        AnimationWin(
            cardPersonOne = R.drawable.all_card_23,
            cardPersonTwo = R.drawable.all_cards0,
            winPerson = Person.ONE
        )
        animateInvisibilityBottomCard()

        LaunchedEffect(true) {
            delay(6000L)
            MainActivity.navController.navigate(Screen.ScreenGamePirsonFirst .route)
        }
    }


}

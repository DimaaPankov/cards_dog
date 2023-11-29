package com.fortunetiasasger.exampale.presentation.screens.winning_a_move.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fortunetiasasger.exampale.data.models.Person
import com.fortunetiasasger.exampale.data.repository.StaticDate
import com.fortunetiasasger.exampale.presentation.activity.MainActivity
import com.fortunetiasasger.exampale.presentation.nav.Screen
import com.fortunetiasasger.exampale.presentation.screens.winning_a_move.usecases.AnimationWin
import com.fortunetiasasger.exampale.presentation.screens.winning_a_move.usecases.animateInvisibilityBottomCard
import com.fortunetiasasger.exampale.presentation.screens.winning_a_move.usecases.backgroundWin
import com.fortunetiasasger.exampale.presentation.screens.winning_a_move.viewmodel.ViewModelWinMove
import com.fortunetiasasger.exampale.screens.setup_cards.com.fortunetiasasger.exampale.theme.Cards_spels_plus_composeTheme
import com.fortunetiasasger.exampale.utils.whoWin
import kotlinx.coroutines.delay


@Preview(showBackground = true)
@Composable
private fun ShowScreenGame() {
    Cards_spels_plus_composeTheme {
        ScreenWinMove.ShowScreen()
    }
}

object ScreenWinMove {

    val viewModel = ViewModelWinMove()
    @Composable
    fun ShowScreen(
    ) {
            StaticDate.listCardsPersonFirst.remove(StaticDate.cardImgDropedPersonFirst)
            StaticDate.listCardsPersonSecond.remove(StaticDate.cardImgDropedPersonSecond)
        viewModel.goToOtherScreen()
        backgroundWin()
        AnimationWin(
            cardPersonOne = StaticDate.cardImgDropedPersonFirst,
            cardPersonTwo = StaticDate.cardImgDropedPersonSecond,
            winPerson =  whoWin(StaticDate.cardImgDropedPersonFirst,StaticDate.cardImgDropedPersonSecond)
        )
        animateInvisibilityBottomCard()

    }


}

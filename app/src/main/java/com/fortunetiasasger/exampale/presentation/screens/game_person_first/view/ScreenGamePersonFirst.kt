package com.fortunetiasasger.exampale.presentation.screens.game_person_first.view

import androidx.compose.runtime.Composable

import androidx.compose.ui.tooling.preview.Preview
import com.fortunetiasasger.exampale.presentation.screens.game_person_first.usecase.Background_First
import com.fortunetiasasger.exampale.presentation.screens.screen_util.check_animation.SecondCards
import com.fortunetiasasger.exampale.presentation.screens.screen_util.orientation_cards.Orientation_cards
import com.fortunetiasasger.exampale.screens.setup_cards.com.fortunetiasasger.exampale.theme.Cards_spels_plus_composeTheme

@Preview(showBackground = true)
@Composable
private fun PreviewScreenGameFirst() {
    Cards_spels_plus_composeTheme {
        ScreenGamePersonFirst.ShowScreen()
    }
}
object ScreenGamePersonFirst {


    @Composable
    fun ShowScreen() {
        Background_First()
        Orientation_cards(
            SecondCards.FIRST.rotate,
            SecondCards.FIRST.action
        )
}



}

package com.fortunetiasasger.exampale.presentation.screens.game_person_second.view

import android.util.Log
import androidx.compose.runtime.Composable

import androidx.compose.ui.tooling.preview.Preview
import com.fortunetiasasger.exampale.data.models.Person
import com.fortunetiasasger.exampale.data.repository.StaticDate
import com.fortunetiasasger.exampale.presentation.screens.game_person_second.use_case.Background_second
import com.fortunetiasasger.exampale.presentation.screens.screen_util.check_animation.model.CardsDate
import com.fortunetiasasger.exampale.presentation.screens.screen_util.orientation_cards.Orientation_cards
import com.fortunetiasasger.exampale.screens.setup_cards.com.fortunetiasasger.exampale.theme.Cards_spels_plus_composeTheme

@Preview(showBackground = true)
@Composable
private fun ShowScreenGame() {
    Cards_spels_plus_composeTheme {
        ScreenGamePersonSecond.ShowScreen()
    }
}

object ScreenGamePersonSecond {
    @Composable
    fun ShowScreen() {
        StaticDate.personNow = Person.TWO
        Log.d("test_list_card_second",StaticDate.listCardsNow().toString())

        Background_second()
        Orientation_cards(
            person = Person.TWO,
            CardsDate.SECOND.action
        )
    }

}

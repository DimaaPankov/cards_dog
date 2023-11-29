package com.fortunetiasasger.exampale.presentation.screens.game_person_first.view

import android.util.Log
import androidx.compose.runtime.Composable

import androidx.compose.ui.tooling.preview.Preview
import com.fortunetiasasger.exampale.data.models.Person
import com.fortunetiasasger.exampale.data.repository.StaticDate
import com.fortunetiasasger.exampale.presentation.screens.game_person_first.usecase.Background_First
import com.fortunetiasasger.exampale.presentation.screens.screen_util.check_animation.model.CardsDate
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
      StaticDate.personNow = Person.ONE
      Log.d("test_list_card_first",StaticDate.listCardsNow().toString())
      Background_First()
        Orientation_cards(
            Person.ONE,
            CardsDate.FIRST.action
        )
}



}

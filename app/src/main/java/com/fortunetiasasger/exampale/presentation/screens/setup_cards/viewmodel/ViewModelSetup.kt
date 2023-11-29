package com.fortunetiasasger.exampale.presentation.screens.setup_cards.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fortunetiasasger.exampale.data.models.Person
import com.fortunetiasasger.exampale.data.repository.Click
import com.fortunetiasasger.exampale.data.repository.StaticDataApi
import com.fortunetiasasger.exampale.data.repository.StaticDate
import com.fortunetiasasger.exampale.presentation.activity.MainActivity
import com.fortunetiasasger.exampale.presentation.nav.Screen
import com.fortunetiasasger.exampale.utils.allStones
import com.fortunetiasasger.exampale.utils.leftStones
import com.fortunetiasasger.exampale.utils.listStonesCategoryFirst
import com.fortunetiasasger.exampale.utils.listStonesCategorySecond
import com.fortunetiasasger.exampale.utils.rightStones


class ViewModelSetup(val date:StaticDataApi): ViewModel() {

    private var _selectedCard = MutableLiveData(date.selectedCard)
    val selectedCard: LiveData<Int> = _selectedCard
    fun clickBack() {
        if (StaticDate.clickedCraftOrPreview == Click.CRAFT) {
            StaticDate.listCardsAdd(date.selectedCard)
            if (StaticDate.listCardsNow().size == 6) {
                if (
                    StaticDate.personNow == Person.ONE
                ) {
                    StaticDate.personNow = Person.TWO
                    MainActivity.navController.navigate(Screen.ScreenPlayers.route)
                    StaticDate.cardsLevel = 0f
                    StaticDate.listStonesCategory = listStonesCategorySecond()
                    StaticDate.listStoneLeftPersonTwo =
                        leftStones(allStones(StaticDate.listStonesCategory))
                    StaticDate.listStoneRightPersonTwo =
                        rightStones(allStones(StaticDate.listStonesCategory))

                } else {
                    MainActivity.navController.navigate(Screen.ScreenGameBegin.route)
                }
            } else {
                MainActivity.navController.navigate(Screen.ScreenChooseStones.route)
            }
        }else{
            MainActivity.navController.navigate(Screen.ScreenChooseStones.route)

        }
    }
   /* private val _isClickedBack = MutableLiveData(false)
    val isClickedBackState: LiveData<Boolean> = _isClickedBack

    fun isClickedBackState(state:Boolean){
        _isClickedBack.value = state
    }

    fun addListCards(cards:Int){
        date.listCardsPersonFirst.add(cards)
    }
    var selectedCard = MutableLiveData(date.cardNowPreview)




    private var _showCardState = MutableLiveData(R.drawable.all_card)
    val showCardState: LiveData<Int> = _showCardState



    fun showCardState(img:Int){
        _showCardState.value = img
    }
*/
}
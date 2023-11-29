package com.fortunetiasasger.exampale.presentation.screens.choosestones.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fortunetiasasger.exampale.data.repository.Click
import com.fortunetiasasger.exampale.data.repository.StaticDataApi
import com.fortunetiasasger.exampale.data.repository.StaticDate
import com.fortunetiasasger.exampale.presentation.activity.MainActivity
import com.fortunetiasasger.exampale.presentation.nav.Screen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
class ViewModelChooseStone(val date:StaticDataApi) : ViewModel() {

     private val LEVEL_LOADING = 0.1435f

    val  listStoneLeft: MutableLiveData<MutableList<Int>> = MutableLiveData(StaticDate.listStoneLeftNow())
    val  listStoneRight: MutableLiveData<MutableList<Int>> = MutableLiveData(StaticDate.listStoneRightNow())
    val  levelLoadingState: MutableLiveData<Float> = MutableLiveData(StaticDate.cardsLevel)

    fun clickToCraft() {

        StaticDate.clickedCraftOrPreview = Click.CRAFT
        StaticDate.cardsLevel += LEVEL_LOADING
        levelLoadingState.value = StaticDate.cardsLevel

        CoroutineScope(Dispatchers.Main).launch {
            delay(120L)
            date.listStoneLeftNow().remove(StaticDate.stoneLeft)
            date.listStoneRightNow().remove(StaticDate.stoneRight)
            MainActivity.navController.navigate(Screen.ScreenSetupCards.route)
        }
    }
        fun clickToPreview(){
                StaticDate.clickedCraftOrPreview = Click.PREVIEW
                MainActivity.navController.navigate(Screen.ScreenSetupCards.route)
            }

   }

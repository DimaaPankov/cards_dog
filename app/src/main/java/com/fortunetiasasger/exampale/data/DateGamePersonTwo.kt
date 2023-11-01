package com.fortunetiasasger.exampale.data

import androidx.lifecycle.LiveData
import com.fortunetiasasger.exampale.data.model.Person
import com.fortunetiasasger.exampale.presentation.screens.choosestones.view.ChooseStoneApi
import com.fortunetiasasger.exampale.presentation.screens.players.view.PlayersDateApi
import com.fortunetiasasger.exampale.utils.allStones
import com.fortunetiasasger.exampale.utils.leftStones
import com.fortunetiasasger.exampale.utils.listStonesCategory
import com.fortunetiasasger.exampale.utils.rightStones

object DateGamePersonTwo: PlayersDateApi,ChooseStoneApi {
   override var name = ""
    val person = Person.TWO
     val listStonesCategory = listStonesCategory()
    val listStoneLeft = leftStones(allStones(listStonesCategory))
    val listStoneRight = rightStones(allStones(listStonesCategory))
    var stoneLeft = 0
    var stoneRight = 0
    val listCards = mutableListOf<Int>()

}


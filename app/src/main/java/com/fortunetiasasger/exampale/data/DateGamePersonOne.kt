package com.fortunetiasasger.exampale.data

import com.fortunetiasasger.exampale.data.model.Person
import com.fortunetiasasger.exampale.presentation.screens.choosestones.view.ChooseStoneApi
import com.fortunetiasasger.exampale.presentation.screens.players.view.PlayersDateApi
import com.fortunetiasasger.exampale.utils.allStones
import com.fortunetiasasger.exampale.utils.leftStones
import com.fortunetiasasger.exampale.utils.listStonesCategory
import com.fortunetiasasger.exampale.utils.rightStones

object DateGamePersonOne : PlayersDateApi, ChooseStoneApi {
   override var name = ""
  // override var nameUserTwo = ""
    override val person = Person.ONE
    override  val listStonesCategory = listStonesCategory()
    override val listStoneLeftPersonOne = leftStones(allStones(listStonesCategory))
    override  val listStoneRightPersonOne = rightStones(allStones(listStonesCategory))
    override   var stoneLeft = 0
    override   var stoneRight = 0

    override  val listCards = mutableListOf<Int>()


}





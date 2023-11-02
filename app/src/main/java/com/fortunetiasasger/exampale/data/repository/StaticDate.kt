package com.fortunetiasasger.exampale.data.repository

import com.fortunetiasasger.exampale.utils.allStones
import com.fortunetiasasger.exampale.utils.leftStones
import com.fortunetiasasger.exampale.utils.listStonesCategory
import com.fortunetiasasger.exampale.utils.rightStones

object StaticDate:StaticDataApi {
    var name = ""
    override val listCards = mutableListOf<Int>()
    override val listStonesCategory = listStonesCategory()

    val listStoneLeftPersonOne = leftStones(allStones(listStonesCategory))
    val listStoneRightPersonOne = rightStones(allStones(listStonesCategory))
    var stoneLeft = 0
    var stoneRight = 0



}





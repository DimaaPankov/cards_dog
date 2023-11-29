package com.fortunetiasasger.exampale.data.repository

import com.fortunetiasasger.exampale.data.models.Person
import com.fortunetiasasger.exampale.utils.allStones
import com.fortunetiasasger.exampale.utils.leftStones
import com.fortunetiasasger.exampale.utils.listStonesCategoryFirst
import com.fortunetiasasger.exampale.utils.rightStones

object StaticDate : StaticDataApi {
    override var nameFirst = "First person"
    override var nameSecond = "Second person"
    override var selectedCard: Int = 0

    var cardImgDropedPersonFirst = 0
    var cardImgDropedPersonSecond = 0
    var pointsCardsFirst = 0
    var pointsCardsSecond = 0

    var clickedCraftOrPreview = Click.CRAFT
    override var listCardsPersonFirst = mutableListOf<Int>()
    var listCardsPersonSecond = mutableListOf<Int>()
    override var listStonesCategory = listStonesCategoryFirst()
    override var stoneLeft = 0
    override var stoneRight = 0
    override var cardsLevel = 0f
    override var personNow = Person.ONE

    override var listStoneLeftPersonOne = leftStones(allStones(listStonesCategory))
    override var listStoneRightPersonOne = rightStones(allStones(listStonesCategory))

    override var listStoneLeftPersonTwo = leftStones(allStones(listStonesCategory))
    override var listStoneRightPersonTwo = rightStones(allStones(listStonesCategory))

    fun listCardsNow() = if (Person.ONE == personNow) {
        listCardsPersonFirst
    } else {
        listCardsPersonSecond
    }

    fun listCardsAdd(img: Int) = if (Person.ONE == personNow) {
        listCardsPersonFirst.add(img)
    } else {
        listCardsPersonSecond.add(img)
    }

    override fun listStoneLeftNow() = if (Person.ONE == personNow) {
        listStoneLeftPersonOne
    } else {
        listStoneLeftPersonTwo
    }

    override fun listStoneRightNow() = if (Person.ONE == personNow) {
        listStoneRightPersonOne
    } else {
        listStoneRightPersonTwo
    }

    fun reboot() {

        nameFirst = "First person"
        nameSecond = "Second person"
        selectedCard = 0

        cardImgDropedPersonFirst = 0
        cardImgDropedPersonSecond = 0
        pointsCardsFirst = 0
        pointsCardsSecond = 0


        listCardsPersonFirst = mutableListOf()
        listCardsPersonSecond = mutableListOf()
        listStonesCategory = listStonesCategoryFirst()
        stoneLeft = 0
        stoneRight = 0
        cardsLevel = 0f
        personNow = Person.ONE

        listStoneLeftPersonOne = leftStones(allStones(listStonesCategory))
        listStoneRightPersonOne = rightStones(allStones(listStonesCategory))

        listStoneLeftPersonTwo = leftStones(allStones(listStonesCategory))
        listStoneRightPersonTwo = rightStones(allStones(listStonesCategory))

    }

}

enum class Click{
    CRAFT,PREVIEW
}





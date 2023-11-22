package com.fortunetiasasger.exampale.data.repository

import com.fortunetiasasger.exampale.data.models.Person
import com.fortunetiasasger.exampale.utils.allStones
import com.fortunetiasasger.exampale.utils.leftStones
import com.fortunetiasasger.exampale.utils.listStonesCategory
import com.fortunetiasasger.exampale.utils.rightStones

object StaticDate:StaticDataApi {
    override var nameFirst = ""
    override var nameSecond = ""
    override var cardNow: Int = 0
    override var listCardsPersonFirst = mutableListOf<Int>()
             var listCardsPersonSecond = mutableListOf<Int>()
             fun listCardsNow() = if(Person.ONE == person){
        listCardsPersonFirst
             }else{
        listCardsPersonSecond
    }
             fun listCardsAdd(img:Int) = if(Person.ONE == person){
                 listCardsPersonFirst.add(img)
             }else{
                 listCardsPersonSecond.add(img)
             }

    override val listStonesCategory = listStonesCategory()
    override  var stoneLeft = 0
    override  var stoneRight = 0
    override var cardsLevel = 0f
    var person = Person.ONE

    override val listStoneLeftPersonOne = leftStones(allStones(listStonesCategory))
    override val listStoneRightPersonOne = rightStones(allStones(listStonesCategory))

    override val listStoneLeftPersonTwo = leftStones(allStones(listStonesCategory))
    override val listStoneRightPersonTwo = rightStones(allStones(listStonesCategory))

    fun listStoneLeftNow() = if(Person.ONE == person){
        listStoneLeftPersonOne
    }else{
        listStoneLeftPersonTwo
    }

    fun listStoneRightNow() = if(Person.ONE == person){
        listStoneRightPersonOne
    }else{
        listStoneRightPersonTwo
    }



}





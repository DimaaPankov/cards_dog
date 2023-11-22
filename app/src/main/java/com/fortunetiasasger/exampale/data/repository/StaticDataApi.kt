package com.fortunetiasasger.exampale.data.repository

import com.fortunetiasasger.exampale.data.models.Stone

interface StaticDataApi {
  var listCardsPersonFirst:MutableList<Int>
  val listStonesCategory: List<Stone>
  var nameFirst:String
  var nameSecond:String
  var cardNow:Int
  var stoneLeft:Int
  var stoneRight:Int

  val listStoneLeftPersonOne:MutableList<Int>
  val listStoneRightPersonOne:MutableList<Int>
  val listStoneLeftPersonTwo:MutableList<Int>
  val listStoneRightPersonTwo:MutableList<Int>

  var cardsLevel:Float
}
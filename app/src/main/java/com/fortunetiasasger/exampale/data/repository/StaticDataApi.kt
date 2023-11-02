package com.fortunetiasasger.exampale.data.repository

import com.fortunetiasasger.exampale.data.models.Stone

interface StaticDataApi {
  val listCards:MutableList<Int>
  val listStonesCategory: List<Stone>
}
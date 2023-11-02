package com.fortunetiasasger.exampale.utils

import com.fortunetiasasger.exampale.R
import com.fortunetiasasger.exampale.data.models.Stone
import kotlin.random.Random

private fun sumOfElements(sheet: MutableList<Int>): Int {
    var sum = 0
    for (row in sheet) {
        sum += row
    }
    return sum
}
var erorrRandomCountStone = listOf(listOf(1,2,1,4,2,2),listOf(3,1,1,2,3,2)
    ,listOf(4,4,1,1,1,1),listOf(2,2,2,2,1,3),listOf(3,2,1,3,2,1))


fun generateListWithMaxSum(): List<Int> {
    val resultList = mutableListOf<Int>()

    // Function to generate a random integer between 1 and 4
    fun randomInt(): Int = Random.nextInt(1, 4)

    // Generate the first five elements
    for (i in 1..5) {
        val remainingSize = 6 - resultList.size
        val maxAllowedValue = 12 - resultList.sum()
        if (remainingSize * 4 <= maxAllowedValue) {
            // If remaining slots can be filled with 4's, add them
            resultList.addAll(List(remainingSize) { 4 })
            break
        } else {
            // Otherwise, add a random number between 1 and 4
            resultList.add(randomInt())
        }
    }

    // Ensure the last element doesn't exceed the remaining sum
    val remainingSum = 12 - resultList.sum()
    resultList.add(if (remainingSum >= 4) 4 else Random.nextInt(1, remainingSum + 1))

    return if(sumOfElements(resultList) == 12)resultList else { erorrRandomCountStone.random()}
}

fun listStonesCategory():List<Stone>{

    val listCategryStone = listOf(
        R.drawable.blue,
        R.drawable.light_purple,
        R.drawable.yellow,
        R.drawable.purple,
        R.drawable.green,
        R.drawable.orange,
        )
    val listCountStones = generateListWithMaxSum()

  return  listOf<Stone>(
        Stone(
            listCategryStone.random(),
            listCountStones[0]
    ),
        Stone(
            listCategryStone.random(),
            listCountStones[1]
        ),
        Stone(
            listCategryStone.random(),
            listCountStones[2]
        ),
        Stone(
            listCategryStone.random(),
            listCountStones[3]
        ),
        Stone(
            listCategryStone.random(),
            listCountStones[4]
        ),
        Stone(
            listCategryStone.random(),
            listCountStones[5]
        )
  )
}



fun allStones(listStone: List<Stone>):List<Int>{
    val finalList = mutableListOf<Int>()
    for(i in listStone){
        repeat(i.count){
            finalList.add(i.img)
        }
    }
    return finalList.toList()
}

fun leftStones(list:List<Int>):MutableList<Int>{
val finalList = mutableListOf<Int>()
    finalList.add(list[0])
    finalList.add(list[1])
    finalList.add(list[2])
    finalList.add(list[3])
    finalList.add(list[4])
    finalList.add(list[5])
    return finalList
}

fun rightStones(list:List<Int>):MutableList<Int>{
    val finalList = mutableListOf<Int>()
    finalList.add(list[6])
    finalList.add(list[7])
    finalList.add(list[8])
    finalList.add(list[9])
    finalList.add(list[10])
    finalList.add(list[11])
    return finalList
}



fun getCard(stoneL: Int, stoneR: Int): Int {
    val SERENY = R.drawable.purple
    val GREEN = R.drawable.green
    val PINK = R.drawable.light_purple
    val ORANGE = R.drawable.orange
    val YELLOW = R.drawable.yellow
    val BLUE = R.drawable.blue

    return when {
        (stoneL == SERENY && stoneR == SERENY) -> R.drawable.all_card
        (stoneL == SERENY && stoneR == GREEN) -> R.drawable.all_cards0
        (stoneL == SERENY && stoneR == BLUE) -> R.drawable.all_cards1
        (stoneL == SERENY && stoneR == PINK) -> R.drawable.all_cards2
        (stoneL == SERENY && stoneR == ORANGE) -> R.drawable.all_cards3
        (stoneL == SERENY && stoneR == YELLOW) -> R.drawable.all_cards4
        (stoneL == GREEN && stoneR == GREEN) -> R.drawable.all_cards_0009
        (stoneL == GREEN && stoneR == BLUE) -> R.drawable.all_cards_0010
        (stoneL == GREEN && stoneR == PINK) -> R.drawable.all_cards_0011
        (stoneL == GREEN && stoneR == ORANGE) -> R.drawable.all_cards_0012
        (stoneL == GREEN && stoneR == YELLOW) -> R.drawable.all_cards_0013
        (stoneL == GREEN && stoneR == SERENY) -> R.drawable.all_cards_0014
        (stoneL == PINK && stoneR == GREEN) -> R.drawable.all_cards_0015
        (stoneL == PINK && stoneR == BLUE) -> R.drawable.all_cards_0017
        (stoneL == PINK && stoneR == PINK) -> R.drawable.all_cards_0018
        (stoneL == PINK && stoneR == ORANGE) -> R.drawable.all_cards_0019
        (stoneL == PINK && stoneR == YELLOW) -> R.drawable.all_cards_0020
        (stoneL == PINK && stoneR == SERENY) -> R.drawable.all_cards_0021
        (stoneL == ORANGE && stoneR == GREEN) -> R.drawable.all_cards_0022
        (stoneL == ORANGE && stoneR == BLUE) -> R.drawable.all_cards_0024
        (stoneL == ORANGE && stoneR == PINK) -> R.drawable.all_cards_0025
        (stoneL == ORANGE && stoneR == ORANGE) -> R.drawable.all_cards_0026
        (stoneL == ORANGE && stoneR == YELLOW) -> R.drawable.all_cards_0027
        (stoneL == ORANGE && stoneR == SERENY) -> R.drawable.all_cards_0028
        (stoneL == YELLOW && stoneR == GREEN) -> R.drawable.all_cards_0029
        (stoneL == YELLOW && stoneR == BLUE) -> R.drawable.all_cards_0030
        (stoneL == YELLOW && stoneR == PINK) -> R.drawable.all_cards_0031
        (stoneL == YELLOW && stoneR == ORANGE) -> R.drawable.all_cards_0032
        (stoneL == YELLOW && stoneR == YELLOW) -> R.drawable.all_cards_0033
        (stoneL == YELLOW && stoneR == SERENY) -> R.drawable.all_cards_0034
        (stoneL == BLUE && stoneR == GREEN) -> R.drawable.all_cards6
        (stoneL == BLUE && stoneR == BLUE) -> R.drawable.all_cards7
        (stoneL == BLUE && stoneR == PINK) -> R.drawable.all_cards8
        (stoneL == BLUE && stoneR == ORANGE) -> R.drawable.all_cards16
        (stoneL == BLUE && stoneR == YELLOW) -> R.drawable.all_card_23
        (stoneL == BLUE && stoneR == SERENY) -> R.drawable.all_cards_0035
        else -> R.drawable.all_cards_0035

    }
}
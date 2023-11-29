package com.fortunetiasasger.exampale.utils

import android.util.Log
import com.fortunetiasasger.exampale.R
import com.fortunetiasasger.exampale.data.models.Person
import com.fortunetiasasger.exampale.data.models.Stone


fun generateListWithMaxSum(): List<Int> {
    val erorrRandomCountStone = listOf(
        listOf(1, 2, 1, 4, 2, 2),
        listOf(3, 1, 1, 2, 3, 2),
        listOf(4, 4, 1, 1, 1, 1),
        listOf(2, 2, 2, 2, 1, 3),
        listOf(3, 2, 1, 3, 2, 1),
        listOf(4, 1, 4, 3, 3, 1),
        listOf(1, 4, 2, 1, 2, 2),
        listOf(3, 1, 4, 2, 1, 1),
        listOf(1, 3, 2, 3, 1, 2),
        listOf(4, 2, 1, 4, 1, 2),
        listOf(2, 3, 1, 1, 4, 1),
        listOf(3, 4, 2, 1, 1, 1),
        listOf(1, 2, 3, 4, 1, 1),
        listOf(4, 3, 4, 3, 1, 1),
        listOf(2, 1, 1, 2, 3, 3),
        listOf(3, 4, 2, 3, 1, 1),
        listOf(1, 3, 1, 2, 4, 1),
        listOf(4, 2, 4, 1, 1, 2),
        listOf(2, 1, 3, 3, 2, 1),
        listOf(3, 4, 1, 2, 1, 1),
        listOf(1, 2, 4, 3, 3, 1),
        listOf(4, 3, 3, 1, 2, 1),
        listOf(2, 1, 2, 4, 1, 2),
        listOf(3, 4, 1, 2, 1, 1),
        listOf(1, 2, 3, 2, 3, 1),
        listOf(4, 1, 4, 2, 3, 2),
        listOf(2, 3, 1, 1, 2, 3),
        listOf(3, 4, 2, 4, 1, 1),
        listOf(1, 3, 1, 2, 3, 1),
        listOf(4, 2, 4, 1, 3, 1),
        listOf(2, 1, 3, 3, 1, 1),
        listOf(3, 4, 1, 2, 1, 2),
        listOf(1, 2, 4, 3, 4, 0),
        listOf(4, 3, 3, 1, 2, 1),
        listOf(2, 1, 2, 4, 2, 1),
        listOf(3, 4, 1, 3, 1, 1),
        listOf(1, 2, 3, 2, 1, 3),
        listOf(4, 1, 4, 2, 3, 2),
        listOf(2, 3, 1, 1, 2, 3),
        listOf(3, 4, 2, 4, 1, 1),
        listOf(1, 3, 1, 2, 2, 2),
        listOf(4, 2, 4, 1, 3, 1),
        listOf(2, 1, 3, 3, 1, 1),
        listOf(3, 4, 1, 2, 1, 2),
        listOf(1, 2, 4, 3, 3, 1),
        listOf(4, 3, 3, 1, 2, 1),
        listOf(2, 1, 2, 4, 3, 0),
        listOf(3, 4, 1, 3, 1, 1),
        listOf(1, 2, 3, 2, 3, 1)
    )
    return erorrRandomCountStone.random()
}

fun listStonesCategoryFirst():List<Stone>{

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

fun listStonesCategorySecond():List<Stone>{

    val listCategryStone = listOf(
        R.drawable.blue,
        R.drawable.purple,
        R.drawable.green,
        R.drawable.orange,
        R.drawable.light_purple,
        R.drawable.yellow,

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

    Log.d("test_stone_left",stoneImgToString(stoneL).toString())
    Log.d("test_stone_right",stoneImgToString(stoneR).toString())


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
        else -> R.drawable.all_card_23

    }
}

fun stoneImgToString(i:Int):String = when(i){
        R.drawable.purple -> "SERENY"
        R.drawable.green -> "GREEN"
        R.drawable.light_purple -> "PINK"
        R.drawable.orange -> "ORANGE"
        R.drawable.yellow -> "YELLOW"
        R.drawable.blue -> "BLUE"
        else -> "else"
}

data class PointsCards(val img:Int, val attac:Int, val protectetion:Int)

val listCardPointd = listOf(
    PointsCards(R.drawable.all_card,4,2),
    PointsCards(R.drawable.all_card_23,3,3),
    PointsCards(R.drawable.all_cards0,3,5),
    PointsCards(R.drawable.all_cards1,1,5),
    PointsCards(R.drawable.all_cards2,1,5),
    PointsCards(R.drawable.all_cards3,1,4),
    PointsCards(R.drawable.all_cards4,4,5),
    PointsCards(R.drawable.all_cards6,4,1),
    PointsCards(R.drawable.all_cards7,4,6),
    PointsCards(R.drawable.all_cards8,6,5),
    PointsCards(R.drawable.all_cards_0009,6,4),
    PointsCards(R.drawable.all_cards_0010,5,2),
    PointsCards(R.drawable.all_cards_0011,5,1),
    PointsCards(R.drawable.all_cards_0012,5,6),
    PointsCards(R.drawable.all_cards_0013,5,4),
    PointsCards(R.drawable.all_cards_0014,3,1),
    PointsCards(R.drawable.all_cards_0015,6,1),
    PointsCards(R.drawable.all_cards16,6,3),
    PointsCards(R.drawable.all_cards_0018,6,2),
    PointsCards(R.drawable.all_cards_0017,6,6),
    PointsCards(R.drawable.all_cards_0019,5,5),
    PointsCards(R.drawable.all_cards_0020,5,3),
    PointsCards(R.drawable.all_cards_0021,4,3),
    PointsCards(R.drawable.all_cards_0022,4,4),
    PointsCards(R.drawable.all_cards_0024,3,6),
    PointsCards(R.drawable.all_cards_0025,3,4),
    PointsCards(R.drawable.all_cards_0026,3,2),
    PointsCards(R.drawable.all_cards_0027,2,1),
    PointsCards(R.drawable.all_cards_0028,2,2),
    PointsCards(R.drawable.all_cards_0029,2,3),
    PointsCards(R.drawable.all_cards_0030,2,4),
    PointsCards(R.drawable.all_cards_0031,1,1),
    PointsCards(R.drawable.all_cards_0032,1,6),
    PointsCards(R.drawable.all_cards_0033,2,6),
    PointsCards(R.drawable.all_cards_0034,2,5),
    PointsCards(R.drawable.all_cards_0035,1,2)
    )

fun whoWin(imgAttack:Int, imgProtection:Int):Person {
    val attack = getPointImg(imgAttack)
    val protection = getPointImg(imgProtection)

   return when{
        attack.attac > protection.protectetion -> Person.ONE
        attack.attac > protection.protectetion -> Person.TWO
        attack.attac == protection.protectetion -> Person.BOTH
        else -> Person.TWO
        }
    }



fun getPointImg(img:Int):PointsCards{
        listCardPointd.forEach{
            if(it.img == img){
                return it
            }
        }
return PointsCards(0,0,0)
}




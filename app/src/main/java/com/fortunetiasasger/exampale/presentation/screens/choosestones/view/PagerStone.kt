package com.fortunetiasasger.exampale.presentation.screens.choosestones.view

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.fortunetiasasger.exampale.data.DateGamePersonTwo


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PagerStone(listImg: List<Int>,id:String,side: SidesStone){
    val pagerState = rememberPagerState(pageCount = {
        listImg.size
    })
    VerticalPager(
        modifier = Modifier
            .width(120.dp)
            .height(180.dp)
            .layoutId(id),
        state = pagerState) { page ->
        if(side == SidesStone.Lefr) {
            DateGamePersonTwo.stoneLeft = listImg[page]
        }else{
            DateGamePersonTwo.stoneRight = listImg[page]
        }

        Log.d("test_page",page.toString())

        Image(
            painter = painterResource(
                id = listImg[page]),
            contentDescription = null,
            modifier = Modifier
                .width(100.dp)
                .height(150.dp)
                .padding(top = 20.dp)

        )
    }
}

enum class SidesStone(){
    Lefr,Right
}

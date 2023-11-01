package com.fortunetiasasger.exampale.lesson

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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PagerStone(listImg: List<Int>,id:String){
    // Display 10 items
    val pagerState = rememberPagerState(pageCount = {
        listImg.size
    })
    VerticalPager(
             modifier = Modifier
            .width(120.dp)
            .height(180.dp)
            .layoutId(id),
        state = pagerState) { page ->

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







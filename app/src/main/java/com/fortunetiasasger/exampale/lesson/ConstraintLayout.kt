package com.fortunetiasasger.exampale.lesson

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension

@Preview
@Composable
fun ShowConstaraint(){
    exampleConstraint()
}

@Composable
fun exampleConstraint(){
    val constraints = ConstraintSet{
        val greenBox = createRefFor("greenBox")
        val redbox = createRefFor("redBox")
       val guideLine = createGuidelineFromBottom(0.5f)

        constrain(greenBox){
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }
        constrain(redbox){
            top.linkTo(guideLine)
            start.linkTo(greenBox.end)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)

        }
   //    createVerticalChain(greenBox,redbox, chainStyle = ChainStyle.Packed)

    }

    ConstraintLayout(
        constraintSet = constraints,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(modifier = Modifier
            .background(Color.Green)
            .layoutId("greenBox"))

        Box(modifier = Modifier
            .background(Color.Red)
            .layoutId("redBox")
        )

    }

}
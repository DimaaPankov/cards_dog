package com.fortunetiasasger.exampale.lesson.animation

import android.util.Log
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview(showBackground = true)
fun showCornerShape(){
    CornerShape()
}

@Composable
fun CornerShape(){

    Column(
        modifier = Modifier.fillMaxSize()
    ){

        var isVisibale: Boolean by remember {
            mutableStateOf(false)
        }

        var isRound by remember{
            mutableStateOf(false)
        }

        Button(onClick = {
            isVisibale=!isVisibale
            isRound = !isRound
            Log.d("test_2",isRound.toString())
        }) {
            Text(text="Toggle")
        }

        val borderRadius by animateIntAsState(
            targetValue = if(isRound) 100 else 0,
/* animationSpec = spring(
     dampingRatio = Spring.DampingRatioHighBouncy,// Это особый вид анимации называется пружина
     stiffness = Spring.StiffnessLow
 ),*/
  animationSpec = tween(
       durationMillis = 1000,
       delayMillis = 100,
   )
)


Box(
 modifier = Modifier
     .size(200.dp)
     .clip(
         RoundedCornerShape(
             borderRadius
         )
     )
     .background(Color.Red)

)

/* AnimatedVisibility(
 visible = !isVisibale,
 modifier = Modifier
     .fillMaxSize()
     .weight(1f)

) {
Box(modifier = Modifier.background(Color.Red))
}
*/
}
}

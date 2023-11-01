package com.fortunetiasasger.exampale.lesson

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun ShowTetxField(){
    val textFieldState = remember{
        mutableStateOf("")
    }
}
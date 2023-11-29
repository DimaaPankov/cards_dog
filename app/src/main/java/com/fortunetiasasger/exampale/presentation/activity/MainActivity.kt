package com.fortunetiasasger.exampale.presentation.activity

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavController
import com.fortunetiasasger.exampale.R
import com.fortunetiasasger.exampale.lesson.swipe.l1.ShowDragle
import com.fortunetiasasger.exampale.presentation.nav.Navigation


class MainActivity : ComponentActivity() {

    companion object {
        lateinit var navController: NavController
        lateinit var context: Context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this

        setContent {
            Navigation()
        }
    }
}
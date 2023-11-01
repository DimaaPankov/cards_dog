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

    companion object{
        lateinit var navController:NavController
        lateinit var context: Context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this

        setContent {
            Navigation()
         // ShowDragle()

        /*    Pager(
              listImg =   listOf(
                    R.drawable.blue,
                    R.drawable.green,
                    R.drawable.light_purple,
                    R.drawable.orange)
                ,id = "srdgf")
            */
          //DraggableText()
         //   Greeting()
            // bStart()
           // Visibility()
           // CornerShape()
            //Collor()
           // DefaultVisibility()
                // CustomVisibility()

        }
    }

}

/*
implementation("androidx.lifecycle:lifecycle-view-model-compose:2.6.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.navigation:navigation-compose:2.7.4")
    implementation("androidx.constraintlayout:constraintlayout-compose:1.0.1")
    implementation("androidx.compose.material3:material3-android:1.2.0-alpha10")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    val composeBom = platform("androidx.compose:compose-bom:2023.10.01")
    implementation(composeBom)
    androidTestImplementation(composeBom)
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.material:material")
    implementation("androidx.compose.foundation:foundation")
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-tooling-preview")
    debugImplementation("androidx.compose.ui:ui-tooling")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    implementation("androidx.compose.material:material-icons-core")
    implementation("androidx.compose.material:material-icons-extended")
    implementation("androidx.compose.material3:material3-window-size-class")
    implementation("androidx.activity:activity-compose:1.8.0")
    implementation("androidx.compose.runtime:runtime-livedata")
    implementation("androidx.compose.runtime:runtime-rxjava2")
 */
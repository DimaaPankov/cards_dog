package com.fortunetiasasger.exampale.lesson.animation.visibility

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp




@Composable
fun CustomVisibility(){
    var visible:Boolean by remember { mutableStateOf(true) }
    val density = LocalDensity.current


  Column(
      modifier = Modifier.fillMaxSize()
  ) {


    Button(onClick = {
        visible=!visible
    }) {
        Text(text="Toggle")
    }

    AnimatedVisibility(
        visible = visible,
        // enter за появление exit за исчезновение
        enter = slideInVertically()
                + expandVertically()
                + fadeIn(),
      exit = slideOutHorizontally()//Смещает влево по горизонтали
              + shrinkHorizontally()//Сжимается по горизонтали
              + fadeOut()// За исчезновение
    ) {
        Box(
            modifier =Modifier.fillMaxSize(0.6f)
                .background(Color.Red)
            ) {

        }
    }
    }
}

//Опубликованный вами код, судя по всему, написан в Jetpack Compose, современном наборе инструментов пользовательского интерфейса Android. Он используется для создания анимированного эффекта видимости для фрагмента контента, такого как элемент "Текст" с надписью "Привет". Давайте разберем, как работает этот код:
//
//AnimatedVisibility - это компонуемый объект, который позволяет вам анимировать видимость его содержимого. Параметр visible - это логическое значение, которое определяет, должно ли содержимое быть видимым или нет.
//
//Параметр enter указывает, как должно отображаться содержимое, когда оно станет видимым. В этом случае вы связали несколько анимаций воедино:
//
//Скользить вертикально: эта анимация заставляет содержимое перемещаться по вертикали с заданного расстояния. В этом случае он сдвигается на 40 пикселей, не зависящих от плотности (dp), над верхней частью.
//Расширяться вертикально: эта анимация заставляет содержимое расширяться вертикально сверху.
//Затухание: эта анимация приводит к затуханию содержимого с начальной альфа-частотой 0,3 (непрозрачность 30%).
//Параметр exit указывает, как содержимое должно отображаться
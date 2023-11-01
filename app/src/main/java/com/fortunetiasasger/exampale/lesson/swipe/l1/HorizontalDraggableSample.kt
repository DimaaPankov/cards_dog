package com.fortunetiasasger.exampale.lesson.swipe.l1

import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.AnchoredDraggableState
import androidx.compose.foundation.gestures.DraggableAnchors
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.anchoredDraggable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalDraggableSample(
    modifier: Modifier = Modifier,
) {
    // Здесь устанавливаются различные пороги и спецификации анимации.
    // В этом коде настраивается Composable для горизонтального перетаскиваемого содержимого.

    val density = LocalDensity.current
    val positionalThreshold = { distance: Float -> distance * 0.5f }
    val velocityThreshold = { with(density) { 100.dp.toPx() } }
    val animationSpec = tween<Float>()
    val state = rememberSaveable(
        density,
        saver = AnchoredDraggableState.Saver(
            animationSpec = animationSpec,
            positionalThreshold = positionalThreshold,
            velocityThreshold = velocityThreshold,
        )
    ) {
        // Этот блок инициализирует состояние для привязанного перетаскивания.
        AnchoredDraggableState(
            initialValue = DragAnchors.Half, // использоваться для привязки перетаскиваемого содержимого при первом рендеринге.initialValu
            positionalThreshold = positionalThreshold,//используемое для определения того, будет ли содержимое анимироваться до следующей привязки или возвращаться к исходной привязке
            velocityThreshold = velocityThreshold,//определения того, следует ли нам анимироваться к следующему якорю, независимо от . Если скорость перетаскивания превысит этот порог, то мы будем анимироваться к следующему якорю,
            animationSpec = animationSpec//для определения способа анимации перетаскиваемого содержимого,
        )
    }
    // Здесь определяется размер и позиционирование перетаскиваемого содержимого.
    val contentSize = 80.dp
    val contentSizePx = with(density) { contentSize.toPx() }
    Box(
        modifier
            .onSizeChanged { layoutSize ->
                val dragEndPoint = layoutSize.width - contentSizePx
                state.updateAnchors(
                    DraggableAnchors {
                        DragAnchors
                            .values()
                            .filterNot { anchor -> anchor == DragAnchors.OneQuarter || anchor == DragAnchors.ThreeQuarters }
                            .forEach { anchor ->
                                anchor at dragEndPoint * anchor.fraction
                            }
                    }
                )
            }
    ) {
        // Создание перетаскиваемого содержимого и установка его позиции.
        DraggableContent(
            modifier = Modifier
                .size(contentSize)
                .offset {
                    IntOffset(
                        x = state.requireOffset().roundToInt(),
                        y = 0,
                    )
                }
                .anchoredDraggable(state, Orientation.Horizontal),
        )
    }
}
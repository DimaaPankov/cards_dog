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
fun VerticalDraggableSample(
    modifier: Modifier = Modifier,
) {
    // Аналогично `HorizontalDraggableSample`, этот код настраивает состояние и пороги для вертикального перетаскиваемого содержимого.

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
        // Инициализация состояния для привязанного перетаскивания в вертикальном направлении.
        AnchoredDraggableState(
            initialValue = DragAnchors.Half,//ачальное значение, к которому будет привязано перетаскиваемое содержимое при первом рендеринге.
            positionalThreshold = positionalThreshold,//лямбда, возвращающая скорость, используемую для определения, следует ли анимироваться к следующей якорной точке
            velocityThreshold = velocityThreshold,//Если скорость перетаскивания превышает этот порог, то будет выполнена анимация до следующей якорной точки, в противном случае будет использован positionalThreshold
            animationSpec = animationSpec// - определяет способ анимации перетаскиваемого содержимого,
        )
    }
    // Определение размера и позиционирования перетаскиваемого содержимого.
    val contentSize = 80.dp
    val contentSizePx = with(density) { contentSize.toPx() }
    Box(
        modifier
            .onSizeChanged { layoutSize ->
                val dragEndPoint = layoutSize.height - contentSizePx

                //updateAnchors Мы используем этот метод для указания точек остановки вдоль зоны перетаскивания
                state.updateAnchors(
                    DraggableAnchors {
                        // Определение якорей для вертикального перетаскивания.
                        DragAnchors
                            .values()
                            .forEach { anchor ->
                                anchor at dragEndPoint * anchor.fraction
                            }
                    }
                )
            }
    ) {
        DraggableContent(
            modifier = Modifier
                .size(contentSize)
                .offset {
                    IntOffset(
                        x = 0,
                        y = state.requireOffset().roundToInt(),
                    )
                }
                .anchoredDraggable(state, Orientation.Vertical),
        )
    }
}

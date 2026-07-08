package com.neitrem.jetchat.ui.customShapes

import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

class LeftBubbleShape(
    private val cornerShape: Dp = 16.dp,
    private val arrowWidth: Dp = 8.dp,
    private val arrowHeight: Dp = 12.dp,
) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density,
    ): Outline =
        Outline.Generic(
            Path().apply {
                val cornerShape = with(density) { cornerShape.toPx() }
                val arrowWidth = with(density) { arrowWidth.toPx() }
                val arrowHeight = with(density) { arrowHeight.toPx() }

                reset()

                moveTo(0f, 0f)

                lineTo(size.width - cornerShape, 0f)

                arcTo(
                    rect =
                        Rect(
                            offset = Offset(size.width - cornerShape, 0f),
                            size = Size(cornerShape, cornerShape),
                        ),
                    startAngleDegrees = 270f,
                    sweepAngleDegrees = 90f,
                    forceMoveTo = false,
                )

                lineTo(size.width, size.height - cornerShape)

                arcTo(
                    rect =
                        Rect(
                            offset = Offset(size.width - cornerShape, size.height - cornerShape),
                            size = Size(cornerShape, cornerShape),
                        ),
                    startAngleDegrees = 0f,
                    sweepAngleDegrees = 90f,
                    forceMoveTo = false,
                )

                lineTo((size.width - cornerShape), size.height)

                arcTo(
                    rect =
                        Rect(
                            offset = Offset(0f + arrowWidth, size.height - cornerShape),
                            size = Size(cornerShape, cornerShape),
                        ),
                    startAngleDegrees = 90f,
                    sweepAngleDegrees = 90f,
                    forceMoveTo = false,
                )

                lineTo(0f + arrowWidth, 0 + arrowHeight)

                arcTo(
                    rect =
                        Rect(
                            offset = Offset(0f, 0f),
                            size = Size(10f, 10f),
                        ),
                    startAngleDegrees = 90f,
                    sweepAngleDegrees = 180f,
                    forceMoveTo = false,
                )
                close()
            },
        )
}
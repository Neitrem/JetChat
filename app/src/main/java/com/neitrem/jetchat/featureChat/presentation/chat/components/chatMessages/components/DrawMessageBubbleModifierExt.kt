package com.neitrem.jetchat.featureChat.presentation.chat.components.chatMessages.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.neitrem.jetchat.ui.customShapes.LeftBubbleShape
import com.neitrem.jetchat.ui.customShapes.RightBubbleShape

@Composable
fun Modifier.drawMessageBubble(
    isAuthorLogin: Boolean,
    cornerShape: Dp = 16.dp,
    arrowWidth: Dp = 8.dp,
    arrowHeight: Dp = 12.dp,
) = padding(
    start = if (isAuthorLogin) 12.dp else 35.dp,
    end = if (isAuthorLogin) 35.dp else 12.dp,
).background(
    color =
        if (isAuthorLogin) {
            MaterialTheme.colorScheme.primary
        } else {
            MaterialTheme.colorScheme.secondary
        },
    shape =
        if (isAuthorLogin) {
            RightBubbleShape(
                cornerShape = cornerShape,
                arrowWidth = arrowWidth,
                arrowHeight = arrowHeight,
            )
        } else {
            LeftBubbleShape(
                cornerShape = cornerShape,
                arrowWidth = arrowWidth,
                arrowHeight = arrowHeight,
            )
        },
)
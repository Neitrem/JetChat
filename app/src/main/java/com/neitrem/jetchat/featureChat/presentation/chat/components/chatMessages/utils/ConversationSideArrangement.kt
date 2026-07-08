package com.neitrem.jetchat.featureChat.presentation.chat.components.chatMessages.utils

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

sealed interface ConversationSideArrangement : Arrangement.Horizontal {
    data object Sender : ConversationSideArrangement {
        override fun Density.arrange(
            totalSize: Int,
            sizes: IntArray,
            layoutDirection: LayoutDirection,
            outPositions: IntArray,
        ) {
            with(Arrangement.Start) {
                arrange(
                    totalSize = totalSize,
                    sizes = sizes,
                    layoutDirection =
                        when (layoutDirection) {
                            LayoutDirection.Ltr -> LayoutDirection.Rtl
                            LayoutDirection.Rtl -> LayoutDirection.Ltr
                        },
                    outPositions = outPositions,
                )
            }
        }
    }

    data object Receiver :
        ConversationSideArrangement,
        Arrangement.Horizontal by Arrangement.Start
}
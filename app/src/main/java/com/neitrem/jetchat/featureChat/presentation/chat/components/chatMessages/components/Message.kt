package com.neitrem.jetchat.featureChat.presentation.chat.components.chatMessages.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.neitrem.jetchat.R
import com.neitrem.jetchat.featureChat.domain.models.MessageModel
import com.neitrem.jetchat.ui.customShapes.LeftBubbleShape
import com.neitrem.jetchat.ui.customShapes.RightBubbleShape
import java.time.Instant
import java.util.Date

@Composable
fun Message(message: MessageModel) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment =
            when {
                message.authorID != "111" -> Alignment.Start
                else -> Alignment.End
            },
    ) {
        Row(
            modifier =
                Modifier
                    .wrapContentSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement =
                when {
                    message.authorID != "111" -> ConversationSide.Receiver
                    else -> ConversationSide.Sender
                },
        ) {
            Image(
                painter =
                    rememberAsyncImagePainter(
                        model =
                            "https://yavuzceliker.github.io/sample-images/" +
                                "image-${message.authorID}.jpg",
                        placeholder = painterResource(R.drawable.photo),
                    ),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier =
                    Modifier
                        .clip(CircleShape)
                        .size(30.dp),
            )
            Text(message.authorID, modifier = Modifier.padding(start = 5.dp, end = 5.dp))
        }
        Box(
            modifier =
                Modifier
                    .wrapContentSize()
                    .drawMessageBubble(
                        isAuthorLogin = message.authorID == "111",
                    ),
        ) {
            Text(
                text = message.text,
                modifier =
                    Modifier.padding(
                        20.dp,
                    ),
            )
        }
    }
}

@Preview
@Composable
private fun PreviewMessage() {
    Message(
        message =
            MessageModel(
                "1",
                authorID = "111",
                isSeen = true,
                sendTime = Date.from(Instant.parse("2007-12-03T10:15:30.00Z")),
                reactions = emptyList(),
                text = "Test text",
            ),
    )
}

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

private sealed interface ConversationSide : Arrangement.Horizontal {
    data object Sender : ConversationSide {
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
        ConversationSide,
        Arrangement.Horizontal by Arrangement.Start
}
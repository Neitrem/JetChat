package com.neitrem.jetchat.featureChat.presentation.chat.components.chatMessages.components

import android.os.Message
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
import com.neitrem.jetchat.featureChat.presentation.chat.components.chatMessages.utils.ConversationSide
import com.neitrem.jetchat.ui.customShapes.LeftBubbleShape
import com.neitrem.jetchat.ui.customShapes.RightBubbleShape
import java.time.Instant
import java.util.Date

@Composable
fun Message(message: MessageModel) {
    Column(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
        horizontalAlignment =
            when {
                message.authorID != "111" -> Alignment.Start
                else -> Alignment.End
            },
    ) {
        AuthorInfo(message)
        MessageBody(message)
    }
}

@Composable
fun AuthorInfo(message: MessageModel) {
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
}

@Composable
fun MessageBody(message: MessageModel) {
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
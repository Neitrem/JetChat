package com.neitrem.jetchat.featureChat.presentation.chat.components.chatMessages

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.neitrem.jetchat.featureChat.domain.models.MessageModel
import com.neitrem.jetchat.featureChat.presentation.chat.components.chatMessages.components.Message
import java.time.Instant
import java.util.Date

var messageList: List<MessageModel> =
    listOf(
        MessageModel(
            messageID = "1",
            authorID = "111",
            isSeen = true,
            sendTime = Date.from(Instant.parse("2007-12-03T10:15:30.00Z")),
            reactions = emptyList(),
            text = "Hello! 23",
        ),
        MessageModel(
            messageID = "1",
            authorID = "222",
            isSeen = true,
            sendTime = Date.from(Instant.parse("2007-12-03T10:16:30.00Z")),
            reactions = emptyList(),
            text = "Hello! asdas dasd as",
        ),
        MessageModel(
            messageID = "1",
            authorID = "222",
            isSeen = true,
            sendTime = Date.from(Instant.parse("2007-12-03T10:16:30.00Z")),
            reactions = emptyList(),
            text = "Hello! asdas dasd as",
        ),
        MessageModel(
            messageID = "1",
            authorID = "222",
            isSeen = true,
            sendTime = Date.from(Instant.parse("2007-12-03T10:16:30.00Z")),
            reactions = emptyList(),
            text = "Hello! asdas dasd as",
        ),
        MessageModel(
            messageID = "1",
            authorID = "222",
            isSeen = true,
            sendTime = Date.from(Instant.parse("2007-12-03T10:16:30.00Z")),
            reactions = emptyList(),
            text = "Hello! asdas dasd as",
        ),
    )

@Preview
@Composable
fun ChatMessages(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.padding(horizontal = 10.dp),
        reverseLayout = true,
    ) {
        items(messageList) { message -> Message(message) }
    }
}
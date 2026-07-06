package com.neitrem.jetchat.featureChat.presentation.chat.components.chatBottomBar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.neitrem.jetchat.R
import com.neitrem.jetchat.ui.theme.JetChatTheme

@Preview()
@Composable
fun ChatBottomBar(
    chatBottomBarViewModel: ChatBottomBarViewModel = viewModel(),
    chatTitle: String = "Test Title",
) {
    ChatBottomBarContent(
        textFieldValue = chatBottomBarViewModel.textFieldState.value,
        chatTitle = chatTitle,
    ) { }
}

@Preview()
@Composable
private fun ChatBottomBarContent(
    textFieldValue: String,
    chatTitle: String,
    onTextChanged: (String) -> Unit,
) {
    JetChatTheme {
        BottomAppBar(
            modifier = Modifier.height(100.dp),
            contentPadding = PaddingValues(0.dp),
            containerColor = MaterialTheme.colorScheme.secondary,
            content = {
                Column {
                    TextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = textFieldValue,
                        onValueChange = onTextChanged,
                        placeholder = { Text("Сообщение #$chatTitle") },
                    )
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth(1f),
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly,
                        ) {
                            ActionIcon(
                                onClick = { /* TODO add action */ },
                                painter = painterResource(R.drawable.bootstrap_emoji_smile),
                            )
                            ActionIcon(
                                onClick = { /* TODO add action */ },
                                painter = painterResource(R.drawable.bootstrap_file_earmark_plus),
                            )
                            ActionIcon(
                                onClick = { /* TODO add action */ },
                                painter = painterResource(R.drawable.bootstrap_geo_alt),
                            )
                            ActionIcon(
                                onClick = { /* TODO add action */ },
                                painter = painterResource(R.drawable.bootstrap_card_image),
                            )
                        }
                        FloatingActionButton(
                            onClick = { /* TODO add action */ },
                        ) {
                            Text(text = "Отправить")
                        }
                    }
                }
            },
        )
    }
}

@Composable
private fun ActionIcon(
    painter: Painter,
    onClick: () -> Unit,
) {
    IconButton(
        onClick = onClick,
    ) {
        Icon(
            painter = painter,
            contentDescription = null,
            modifier = Modifier.size(18.dp),
        )
    }
}
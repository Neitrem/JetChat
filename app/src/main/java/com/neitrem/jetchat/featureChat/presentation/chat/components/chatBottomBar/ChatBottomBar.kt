package com.neitrem.jetchat.featureChat.presentation.chat.components.chatBottomBar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.FloatingActionButtonElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.neitrem.jetchat.R
import com.neitrem.jetchat.ui.theme.JetChatTheme

@Composable
fun ChatBottomBar(
    chatBottomBarViewModel: ChatBottomBarViewModel = viewModel(),
    chatTitle: String,
) {
    ChatBottomBarContent(
        textFieldValue = chatBottomBarViewModel.textFieldState.value,
        chatTitle = chatTitle,
        onTextChanged = { text -> chatBottomBarViewModel.updateTextMethod(text) },
    )
}

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
                        modifier =
                            Modifier
                                .fillMaxWidth(),
                        value = textFieldValue,
                        onValueChange = onTextChanged,
                        placeholder = { Text("Сообщение #$chatTitle") },
                        colors =
                            TextFieldDefaults.colors(
                                unfocusedContainerColor = MaterialTheme.colorScheme.secondary,
                                focusedContainerColor = MaterialTheme.colorScheme.secondary,
                                focusedIndicatorColor = MaterialTheme.colorScheme.secondary,
                                unfocusedIndicatorColor = MaterialTheme.colorScheme.secondary,
                                disabledIndicatorColor = MaterialTheme.colorScheme.secondary,
                            ),
                    )
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier =
                            Modifier
                                .padding(bottom = 5.dp)
                                .fillMaxWidth(1f),
                    ) {
                        Actions()
                        FloatingActionButton(
                            onClick = { /* TODO add action */ },
                            modifier = Modifier.padding(end = 10.dp),
                            containerColor =
                                if (textFieldValue.isEmpty()) {
                                    MaterialTheme.colorScheme.secondary
                                } else {
                                    MaterialTheme.colorScheme.primary
                                },
                        ) {
                            Text(
                                text = "Отправить",
                                modifier =
                                    Modifier
                                        .padding(
                                            horizontal = 10.dp,
                                        ),
                            )
                        }
                    }
                }
            },
        )
    }
}

// Preview class. Only for development
@Preview
@Composable
private fun PreviewChatBottomBarContent() {
    ChatBottomBarContent(
        textFieldValue = "",
        chatTitle = "",
        onTextChanged = {},
    )
}

@Composable
private fun Actions() {
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
            modifier = Modifier.size(20.dp),
        )
    }
}
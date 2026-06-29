package com.neitrem.jetchat.featureChat.presentation.chat.components

import android.R.attr.enabled
import android.R.attr.singleLine
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.neitrem.jetchat.R
import com.neitrem.jetchat.ui.theme.JetChatTheme

@Preview()
@Composable
fun ChatBottomBar(
    chatTitle: String = "Text Title",
    initialText: String = "",
) {
    JetChatTheme {
        BottomAppBar(
            modifier = Modifier.height(100.dp),
            contentPadding = PaddingValues(5.dp),
            containerColor = MaterialTheme.colorScheme.secondary,
            content = {
                Column {
                    TextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = initialText,
                        onValueChange = { },
//                        textStyle = TextStyle(
//                            color = if (isSystemInDarkTheme()) Color(0xFF969EBD) else Color.Gray
//                        ),
                    )
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier =
                            Modifier
                                .fillMaxWidth(1f),
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
            modifier =
                Modifier.size(18.dp),
        )
    }
}
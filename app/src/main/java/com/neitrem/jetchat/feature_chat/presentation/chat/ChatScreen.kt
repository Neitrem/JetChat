package com.neitrem.jetchat.feature_chat.presentation.chat

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.neitrem.jetchat.feature_chat.presentation.chat.components.ChatTopBar

@Composable
fun ChatScreen() {
    Scaffold(
        topBar = { ChatTopBar("Test asd asd  sd d sd sd  s d asd") },
    ) { innerPadding -> Spacer(modifier = Modifier.padding(innerPadding)) }
}
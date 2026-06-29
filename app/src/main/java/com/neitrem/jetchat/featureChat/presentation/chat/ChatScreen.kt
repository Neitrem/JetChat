package com.neitrem.jetchat.featureChat.presentation.chat

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.neitrem.jetchat.featureChat.presentation.chat.components.ChatBottomBar
import com.neitrem.jetchat.featureChat.presentation.chat.components.ChatTopBar

@Composable
fun ChatScreen() {
    Scaffold(
        topBar = { ChatTopBar("Test asd asd  sd d sd sd  s d asd") },
        bottomBar = { ChatBottomBar() },
    ) { innerPadding -> Spacer(modifier = Modifier.padding(innerPadding)) }
}
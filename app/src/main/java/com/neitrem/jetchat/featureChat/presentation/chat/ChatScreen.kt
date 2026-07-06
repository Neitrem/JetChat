package com.neitrem.jetchat.featureChat.presentation.chat

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.neitrem.jetchat.featureChat.presentation.chat.components.ChatTopBar
import com.neitrem.jetchat.featureChat.presentation.chat.components.chatBottomBar.ChatBottomBar
import com.neitrem.jetchat.featureChat.presentation.chat.components.chatBottomBar.ChatBottomBarViewModel
import com.neitrem.jetchat.featureChat.presentation.chat.components.chatBottomBar.ChatBottomBarViewModelFactory

@Composable
fun ChatScreen() {
    Scaffold(
        topBar = { ChatTopBar("Test asd asd  sd d sd sd  s d asd") },
        bottomBar = {
            ChatBottomBar(
                chatBottomBarViewModel =
                    hiltViewModel<ChatBottomBarViewModel, ChatBottomBarViewModel.Factory>(
                        creationCallback = { factory ->
                            factory.create("123")
                        },
                    ),
            )
        },
    ) { innerPadding -> Spacer(modifier = Modifier.padding(innerPadding)) }
}
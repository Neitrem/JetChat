package com.neitrem.jetchat.featureChat.presentation.chat

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.hilt.navigation.compose.hiltViewModel
import com.neitrem.jetchat.featureChat.presentation.chat.components.chatBottomBar.ChatBottomBar
import com.neitrem.jetchat.featureChat.presentation.chat.components.chatBottomBar.ChatBottomBarViewModel
import com.neitrem.jetchat.featureChat.presentation.chat.components.chatMessages.ChatMessages
import com.neitrem.jetchat.featureChat.presentation.chat.components.chatTopBar.ChatTopBar

@Composable
fun ChatScreen() {
    val focusManager = LocalFocusManager.current
    Scaffold(
        modifier =
            Modifier
//                .navigationBarsPadding()
                .imePadding()
                .pointerInput(Unit) {
                    detectTapGestures(
                        onTap = {
                            focusManager.clearFocus()
                        },
                    )
                },
        topBar = { ChatTopBar("Test asd asd  sd d sd sd  s d asd") },
        bottomBar = {
            ChatBottomBar(
                chatTitle = "Text chat title", // TODO change
                chatBottomBarViewModel =
                    hiltViewModel<
                        ChatBottomBarViewModel,
                        ChatBottomBarViewModel.ChatBottomBarViewModelFactory,
                    >(
                        creationCallback = { factory ->
                            factory.create("123")
                        },
                    ),
            )
        },
    ) { innerPadding ->
        ChatMessages(modifier = Modifier.padding(innerPadding))
    }
}
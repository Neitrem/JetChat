package com.neitrem.jetchat.featureChat.presentation.chat

import androidx.lifecycle.ViewModel
import com.neitrem.jetchat.featureChat.presentation.chat.components.chatBottomBar.ChatBottomBarViewModel
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel(assistedFactory = ChatViewModel.ChatViewModelFactory::class)
class ChatViewModel
    @AssistedInject
    constructor() : ViewModel() {
        @AssistedFactory
        interface ChatViewModelFactory {
            fun create(): ChatViewModel
        }
    }
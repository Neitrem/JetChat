package com.neitrem.jetchat.featureChat.presentation.chat

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel(assistedFactory = ChatViewModel.ChatViewModelFactory::class)
class ChatViewModel
    @AssistedInject
    constructor() : ViewModel() {
        init {
            loadData()
        }

        private var _chatState = mutableStateOf(ChatState())

        val chatState: State<ChatState> = _chatState

        @AssistedFactory
        interface ChatViewModelFactory {
            fun create(): ChatViewModel
        }

        fun loadData() {
            _chatState.value = chatState.value.loading()
        }
    }
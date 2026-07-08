package com.neitrem.jetchat.featureChat.presentation.chat

import com.neitrem.jetchat.featureChat.domain.models.MessageModel
import com.neitrem.jetchat.featureChat.domain.models.UserModel
import java.util.Collections.emptyList

open class ChatState {
    var chatTitle: String? = null
    var chatMembers: List<UserModel> = emptyList()
    var messageList: MutableList<MessageModel> = emptyList()

    companion object {
        fun loading(): LoadingChatState = LoadingChatState()
    }
}

class LoadingChatState : ChatState()
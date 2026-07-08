package com.neitrem.jetchat.featureChat.presentation.chat

import com.neitrem.jetchat.featureChat.domain.models.UserModel

class ChatState {
    var chatTitle: String? = null
    var chatMembers: List<UserModel> = emptyList()
}
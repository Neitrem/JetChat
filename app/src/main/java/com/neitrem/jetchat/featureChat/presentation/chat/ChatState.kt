package com.neitrem.jetchat.featureChat.presentation.chat

import com.neitrem.jetchat.featureChat.domain.models.MessageModel
import com.neitrem.jetchat.featureChat.domain.models.UserModel
import java.util.Collections.emptyList

open class ChatState(
    var chatTitle: String? = null,
    var chatMembers: List<UserModel> = emptyList(),
    var messageList: MutableList<MessageModel> = emptyList(),
) {
    companion object {
        fun idle(
            chatTitle: String?,
            chatMembers: List<UserModel>,
            messageList: MutableList<MessageModel>,
        ): IdleChatState = IdleChatState(chatTitle, chatMembers, messageList)

        fun loading(
            chatTitle: String?,
            chatMembers: List<UserModel>,
            messageList: MutableList<MessageModel>,
        ): LoadingChatState = LoadingChatState(chatTitle, chatMembers, messageList)

        fun error(error: Error): ErrorChatState = ErrorChatState(error)
    }
}

// States
class IdleChatState(
    chatTitle: String?,
    chatMembers: List<UserModel>,
    messageList: MutableList<MessageModel>,
) : ChatState(chatTitle, chatMembers, messageList)

class LoadingChatState(
    chatTitle: String?,
    chatMembers: List<UserModel>,
    messageList: MutableList<MessageModel>,
) : ChatState(chatTitle, chatMembers, messageList)

class ErrorChatState(
    var error: Error,
) : ChatState(null, emptyList(), emptyList())

// State create from state extensions
fun ChatState.idle(
    chatTitle: String?,
    chatMembers: List<UserModel>,
    messageList: MutableList<MessageModel>,
): IdleChatState = ChatState.idle(chatTitle, chatMembers, messageList)

fun ChatState.loading(): LoadingChatState = ChatState.loading(chatTitle, chatMembers, messageList)

fun ChatState.error(error: Error): ErrorChatState = ChatState.error(error)
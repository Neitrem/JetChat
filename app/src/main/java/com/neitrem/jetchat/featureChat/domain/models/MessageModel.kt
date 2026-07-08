package com.neitrem.jetchat.featureChat.domain.models

import java.util.Date

class MessageModel {
    val messageID: String
    val authorID: String
    val isSeen: Boolean
    val sendTime: Date
    val reactions: List<String>
    val text: String

    constructor(
        messageID: String,
        authorID: String,
        isSeen: Boolean,
        sendTime: Date,
        reactions: List<String>,
        text: String,
    ) {
        this.messageID = messageID
        this.authorID = authorID
        this.isSeen = isSeen
        this.sendTime = sendTime
        this.reactions = reactions
        this.text = text
    }
}
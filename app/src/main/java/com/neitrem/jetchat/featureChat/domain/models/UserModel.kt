package com.neitrem.jetchat.featureChat.domain.models

class UserModel {
    val id: String
    val firstName: String

    val secondName: String
    val photoUrl: String

    constructor(id: String, firstName: String, secondName: String, photoUrl: String) {
        this.id = id
        this.firstName = firstName
        this.secondName = secondName
        this.photoUrl = photoUrl
    }
}
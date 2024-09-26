package com.codeminds.temporaly.feature_auth.data.remote.dto

import com.codeminds.temporaly.feature_auth.domain.model.Account
import com.google.gson.annotations.SerializedName

class SignInResponseDto (

    @SerializedName("id")
    val id: String,

    @SerializedName("username")
    val username: String,

    @SerializedName("email")
    val email: String,

    @SerializedName("token")
    val token: String
)

fun SignInResponseDto.toAccount() = Account(
    username = username,
    token = token
)
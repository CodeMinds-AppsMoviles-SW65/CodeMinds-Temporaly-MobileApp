package com.codeminds.temporaly.feature_auth.data.remote.dto

import com.google.gson.annotations.SerializedName

class SignInRequestDto (

    @SerializedName("usernameOrEmail")
    val usernameOrEmail: String,

    @SerializedName("password")
    val password: String
)
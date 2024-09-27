package com.codeminds.temporaly.feature_auth.data.remote.dto

import com.google.gson.annotations.SerializedName

class SignUpRequestDto (

    @SerializedName("username")
    val username: String,

    @SerializedName("email")
    val email: String,

    @SerializedName("password")
    val password: String,
)
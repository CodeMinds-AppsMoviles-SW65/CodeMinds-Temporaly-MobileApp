package com.codeminds.temporaly.feature_auth.data.remote.dto

import com.google.gson.annotations.SerializedName

class RefreshTokenResponseDto (

    @SerializedName("id")
    val id: String,

    @SerializedName("username")
    val username: String,

    @SerializedName("email")
    val email: String,

    @SerializedName("token")
    val token: String
)
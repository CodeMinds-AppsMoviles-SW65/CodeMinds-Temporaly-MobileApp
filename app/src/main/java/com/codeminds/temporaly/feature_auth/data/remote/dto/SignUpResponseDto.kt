package com.codeminds.temporaly.feature_auth.data.remote.dto

import com.google.gson.annotations.SerializedName

class SignUpResponseDto (

    @SerializedName("id")
    val id: String,

    @SerializedName("username")
    val username: String,

    @SerializedName("email")
    val email: String,

    @SerializedName("roles")
    val roles: List<String>
)
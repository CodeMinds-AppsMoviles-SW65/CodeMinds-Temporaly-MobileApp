package com.codeminds.temporaly.feature_auth.data.remote.dto

import com.google.gson.annotations.SerializedName

class SignUpRequestDto (

    @SerializedName("names")
    val names: String,

    @SerializedName("lastNames")
    val lastNames: String,

    @SerializedName("email")
    val email: String,

    @SerializedName("password")
    val password: String,

    @SerializedName("roles")
    val roles: List<String>
)
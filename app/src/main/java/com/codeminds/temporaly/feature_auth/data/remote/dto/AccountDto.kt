package com.codeminds.temporaly.feature_auth.data.remote.dto

import com.codeminds.temporaly.feature_auth.domain.model.Account
import com.google.gson.annotations.SerializedName

class AccountDto(

    @SerializedName("id")
    val id: String,

    @SerializedName("username")
    val username: String,

    @SerializedName("names")
    val names: List<String>,

    @SerializedName("lastNames")
    val lastNames: List<String>
)

fun AccountDto.toAccount() = Account(
    username = username,
    names = names.joinToString(" "),
    lastNames = lastNames.joinToString(" ")
)
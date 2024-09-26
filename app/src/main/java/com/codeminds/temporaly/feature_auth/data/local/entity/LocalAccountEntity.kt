package com.codeminds.temporaly.feature_auth.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.codeminds.temporaly.feature_auth.data.remote.dto.AccountDto
import com.codeminds.temporaly.feature_auth.domain.model.Account

@Entity(tableName = "accounts")
data class LocalAccountEntity (

    @PrimaryKey
    val id: String,

    @ColumnInfo(name = "username")
    val username: String,

    @ColumnInfo(name = "token")
    val token: String
)

fun LocalAccountEntity.toAccount(): Account {
    return Account(
        username = username,
        token = token
    )
}
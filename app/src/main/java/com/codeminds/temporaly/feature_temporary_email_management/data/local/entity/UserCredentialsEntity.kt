package com.codeminds.temporaly.feature_temporary_email_management.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user_credentials")
data class UserCredentialsEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var email: String,

    @ColumnInfo(name = "token")
    var token: String,
)

package com.codeminds.temporaly.feature_temporary_email_management.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.codeminds.temporaly.feature_temporary_email_management.data.local.entity.UserCredentialsEntity

@Dao
interface UserCredentialsDao {
    @Insert
    suspend fun insertUserCredentials(userCredentials: UserCredentialsEntity)

    @Delete
    suspend fun deleteUserCredentials(userCredentials: UserCredentialsEntity)

    @Query("SELECT * FROM user_credentials")
    suspend fun getAllUserCredentials(): List<UserCredentialsEntity>
}
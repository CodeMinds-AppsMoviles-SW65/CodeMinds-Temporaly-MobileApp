package com.codeminds.temporaly.feature_auth.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.codeminds.temporaly.feature_auth.data.local.entity.LocalAccountEntity

@Dao
interface LocalAccountDao {

    @Insert
    suspend fun insertAccount(account: LocalAccountEntity)

    @Insert
    suspend fun deleteAccount(account: LocalAccountEntity)

    @Query("SELECT * FROM accounts LIMIT 1")
    suspend fun getAccount(): LocalAccountEntity?
}
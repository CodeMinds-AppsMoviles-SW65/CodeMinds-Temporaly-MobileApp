package com.codeminds.temporaly.feature_auth.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.codeminds.temporaly.feature_auth.data.local.dao.LocalAccountDao
import com.codeminds.temporaly.feature_auth.data.local.entity.LocalAccountEntity

@Database(entities = [LocalAccountEntity::class], version = 1)
abstract class AuthDataBase : RoomDatabase() {

    abstract fun localAccountDao(): LocalAccountDao

}
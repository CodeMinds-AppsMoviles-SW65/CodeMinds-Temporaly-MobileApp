package com.codeminds.temporaly.feature_temporary_email_management.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.codeminds.temporaly.feature_temporary_email_management.data.local.dao.UserCredentialsDao
import com.codeminds.temporaly.feature_temporary_email_management.data.local.entity.UserCredentialsEntity

@Database(entities = [UserCredentialsEntity::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {
    abstract fun userCredentialsDao(): UserCredentialsDao
}
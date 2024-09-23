package com.codeminds.temporaly.feature_example.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.codeminds.temporaly.feature_example.data.local.dao.TimerSessionDao
import com.codeminds.temporaly.feature_example.data.local.entity.TimerSessionEntity

@Database(entities = [TimerSessionEntity::class], version = 1)
abstract class AppDataBase: RoomDatabase() {
    abstract fun timerSessionDao(): TimerSessionDao
}
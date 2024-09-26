package com.codeminds.temporaly.feature_auth.di

import android.content.Context
import androidx.room.Room
import com.codeminds.temporaly.feature_auth.data.local.AuthDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun providesRoomDatabase(@ApplicationContext appContext: Context): AuthDataBase {
        return Room.databaseBuilder(
            appContext,
            AuthDataBase::class.java, "auth_database"
        ).build()
    }

    @Singleton
    @Provides
    fun provideLocalAccountDao(db: AuthDataBase) = db.localAccountDao()
}
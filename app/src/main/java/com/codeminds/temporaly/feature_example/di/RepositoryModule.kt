package com.codeminds.temporaly.feature_example.di

import com.codeminds.temporaly.feature_example.data.repository.TimerSessionRepositoryImpl
import com.codeminds.temporaly.feature_example.domain.repository.TimerSessionRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindTimerSessionRepository(timerSessionRepositoryImpl: TimerSessionRepositoryImpl): TimerSessionRepository
}
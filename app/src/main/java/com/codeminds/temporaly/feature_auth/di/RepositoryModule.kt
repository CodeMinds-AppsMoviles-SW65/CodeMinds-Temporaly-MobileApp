package com.codeminds.temporaly.feature_auth.di

import com.codeminds.temporaly.feature_auth.data.repository.AccountRepositoryImpl
import com.codeminds.temporaly.feature_auth.data.repository.AuthRepositoryImpl
import com.codeminds.temporaly.feature_auth.domain.repository.AccountRepository
import com.codeminds.temporaly.feature_auth.domain.repository.AuthRepository
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
    abstract fun bindAccountRepository(accountRepositoryImpl: AccountRepositoryImpl): AccountRepository

    @Singleton
    @Binds
    abstract fun bindAuthRepository(accountRepositoryImpl: AuthRepositoryImpl): AuthRepository
}
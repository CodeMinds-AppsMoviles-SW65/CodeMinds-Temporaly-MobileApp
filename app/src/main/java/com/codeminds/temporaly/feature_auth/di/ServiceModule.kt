package com.codeminds.temporaly.feature_auth.di

import com.codeminds.temporaly.feature_auth.data.remote.AccountService
import com.codeminds.temporaly.feature_auth.data.remote.AuthService
import com.codeminds.temporaly.feature_auth.data.repository.AccountRepositoryImpl
import com.codeminds.temporaly.feature_auth.data.repository.AuthRepositoryImpl
import com.codeminds.temporaly.feature_auth.domain.repository.AccountRepository
import com.codeminds.temporaly.feature_auth.domain.repository.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    @Singleton
    fun bindAccountService(retrofit: Retrofit): AccountService =
        retrofit.create(AccountService::class.java)

    @Provides
    @Singleton
    fun bindAuthService(retrofit: Retrofit): AuthService =
        retrofit.create(AuthService::class.java)
}
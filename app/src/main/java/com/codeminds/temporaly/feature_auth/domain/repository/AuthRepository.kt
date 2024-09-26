package com.codeminds.temporaly.feature_auth.domain.repository

import com.codeminds.temporaly.feature_auth.data.remote.dto.RefreshTokenResponseDto
import com.codeminds.temporaly.feature_auth.data.remote.dto.SignInResponseDto
import com.codeminds.temporaly.feature_auth.data.remote.dto.SignUpResponseDto

interface AuthRepository {

    suspend fun signIn(
        usernameOrEmail: String,
        password: String
    ): SignInResponseDto

    suspend fun signUp(
        names: String,
        lastNames: String,
        email: String,
        password: String,
        roles: List<String>,
    ): SignUpResponseDto

    suspend fun refreshToken(refreshToken: String): RefreshTokenResponseDto
}
package com.codeminds.temporaly.feature_auth.data.repository

import com.codeminds.temporaly.feature_auth.data.remote.AuthService
import com.codeminds.temporaly.feature_auth.data.remote.dto.RefreshTokenResponseDto
import com.codeminds.temporaly.feature_auth.data.remote.dto.SignInRequestDto
import com.codeminds.temporaly.feature_auth.data.remote.dto.SignInResponseDto
import com.codeminds.temporaly.feature_auth.data.remote.dto.SignUpRequestDto
import com.codeminds.temporaly.feature_auth.data.remote.dto.SignUpResponseDto
import com.codeminds.temporaly.feature_auth.domain.repository.AuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(private val authService: AuthService) :
    AuthRepository {

    override suspend fun signIn(
        usernameOrEmail: String,
        password: String
    ): SignInResponseDto = withContext(Dispatchers.IO) {
        val response = authService.signIn(SignInRequestDto(usernameOrEmail, password))
        if (response.isSuccessful) {
            response.body() ?: throw Exception("An error occurred")
        } else {
            val errorBody = response.errorBody()?.string()
            if (errorBody != null) {
                throw Exception(errorBody)
            }
            throw Exception("Check your credentials")
        }
    }

    override suspend fun signUp(
        username: String,
        email: String,
        password: String,
    ): SignUpResponseDto = withContext(Dispatchers.IO) {
        val response = authService.signUp(SignUpRequestDto(username, email, password))
        if (response.isSuccessful) {
            response.body() ?: throw Exception("An error occurred")
        } else {
            val errorBody = response.errorBody()?.string()
            if (errorBody != null) {
                throw Exception(errorBody)
            }
            throw Exception("An error occurred")
        }
    }

    override suspend fun refreshToken(refreshToken: String): RefreshTokenResponseDto = withContext(Dispatchers.IO) {
        val response = authService.refreshToken(refreshToken)
        if (response.isSuccessful) {
            response.body() ?: throw Exception("An error occurred")
        } else {
            throw Exception("Token refresh failed: ${response.message()}")
        }
    }
}
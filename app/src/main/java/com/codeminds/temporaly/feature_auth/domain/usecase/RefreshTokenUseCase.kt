package com.codeminds.temporaly.feature_auth.domain.usecase

import com.codeminds.temporaly.core.utils.Resource
import com.codeminds.temporaly.feature_auth.data.remote.dto.RefreshTokenResponseDto
import com.codeminds.temporaly.feature_auth.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RefreshTokenUseCase @Inject constructor(private val authRepository: AuthRepository) {

    operator fun invoke(): Flow<Resource<RefreshTokenResponseDto>> = flow {
        try {
            emit(Resource.Loading())
            // get token from shared preferences
            val refreshToken = ""
            val refreshTokenResponseDto = authRepository.refreshToken(refreshToken)
            emit(Resource.Success(data = refreshTokenResponseDto))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "Unknown Error"))
        }
    }
}
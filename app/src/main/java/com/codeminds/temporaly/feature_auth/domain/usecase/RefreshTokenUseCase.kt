package com.codeminds.temporaly.feature_auth.domain.usecase

import com.codeminds.temporaly.core.utils.Resource
import com.codeminds.temporaly.feature_auth.data.remote.dto.RefreshTokenResponseDto
import com.codeminds.temporaly.feature_auth.data.remote.dto.SignInResponseDto
import com.codeminds.temporaly.feature_auth.data.remote.dto.SignUpResponseDto
import com.codeminds.temporaly.feature_auth.domain.repository.AuthRepository

class RefreshTokenUseCase(private val authRepository: AuthRepository) {

    operator fun invoke(
        callback: (Resource<RefreshTokenResponseDto>) -> Unit
    ) {
        callback(Resource.Loading())
        // get token from shared preferences
        val refreshToken = "";
        authRepository.refreshToken(refreshToken) { refreshTokenResponseDto ->
            if (refreshTokenResponseDto != null) {
                callback(Resource.Success(refreshTokenResponseDto))
            } else {
                callback(Resource.Error("An error occurred"))
            }
        }
    }
}
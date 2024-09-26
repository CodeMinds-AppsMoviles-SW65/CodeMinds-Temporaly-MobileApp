package com.codeminds.temporaly.feature_auth.domain.usecase

import com.codeminds.temporaly.core.utils.Resource
import com.codeminds.temporaly.feature_auth.data.remote.dto.SignInResponseDto
import com.codeminds.temporaly.feature_auth.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SignInUseCase @Inject constructor(private val authRepository: AuthRepository) {

    operator fun invoke(usernameOrEmail: String, password: String): Flow<Resource<SignInResponseDto>> = flow {
        try {
            emit(Resource.Loading())
            val signInResponseDto = authRepository.signIn(usernameOrEmail, password)
            emit(Resource.Success(data = signInResponseDto))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "Unknown Error"))
        }
    }
}
package com.codeminds.temporaly.feature_auth.domain.usecase

import com.codeminds.temporaly.core.utils.Resource
import com.codeminds.temporaly.feature_auth.data.remote.dto.SignUpResponseDto
import com.codeminds.temporaly.feature_auth.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SignUpUseCase @Inject constructor(private val authRepository: AuthRepository) {

    operator fun invoke(
        names: String,
        lastNames: String,
        email: String,
        password: String,
        roles: List<String>
    ): Flow<Resource<SignUpResponseDto>> = flow {
        try {
            emit(Resource.Loading())
            val signUpResponseDto = authRepository.signUp(names, lastNames, email, password, roles)
            emit(Resource.Success(data = signUpResponseDto))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "Unknown Error"))
        }
    }
}
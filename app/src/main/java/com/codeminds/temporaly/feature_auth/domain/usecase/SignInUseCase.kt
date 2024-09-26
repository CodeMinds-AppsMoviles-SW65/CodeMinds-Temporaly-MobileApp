package com.codeminds.temporaly.feature_auth.domain.usecase

import com.codeminds.temporaly.core.utils.Resource
import com.codeminds.temporaly.feature_auth.data.remote.dto.SignInResponseDto
import com.codeminds.temporaly.feature_auth.data.remote.dto.SignUpResponseDto
import com.codeminds.temporaly.feature_auth.domain.repository.AuthRepository

class SignInUseCase(private val authRepository: AuthRepository) {

    operator fun invoke(
        usernameOrEmail: String,
        password: String,
        callback: (Resource<SignInResponseDto>) -> Unit
    ) {
        callback(Resource.Loading())
        authRepository.signIn(usernameOrEmail, password) { signInResponseDto ->
            if (signInResponseDto != null) {
                callback(Resource.Success(signInResponseDto))
            } else {
                callback(Resource.Error("An error occurred"))
            }
        }
    }
}
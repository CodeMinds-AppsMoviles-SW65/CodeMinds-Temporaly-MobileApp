package com.codeminds.temporaly.feature_auth.domain.usecase

import com.codeminds.temporaly.core.utils.Resource
import com.codeminds.temporaly.feature_auth.data.remote.dto.SignUpResponseDto
import com.codeminds.temporaly.feature_auth.domain.repository.AuthRepository

class SignUpUseCase (private val authRepository: AuthRepository) {

    operator fun invoke(names: String, lastNames: String, email: String, password: String, roles: List<String>, callback: (Resource<SignUpResponseDto>) -> Unit) {
        callback(Resource.Loading())
        authRepository.signUp(names, lastNames, email, password, roles) { signUpResponseDto ->
             if (signUpResponseDto != null) {
                 callback(Resource.Success(signUpResponseDto))
             } else {
                 callback(Resource.Error("An error occurred"))
             }
        }
    }
}
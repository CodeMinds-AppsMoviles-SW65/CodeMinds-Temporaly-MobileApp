package com.codeminds.temporaly.feature_auth.domain.repository

import com.codeminds.temporaly.feature_auth.data.remote.dto.RefreshTokenResponseDto
import com.codeminds.temporaly.feature_auth.data.remote.dto.SignInResponseDto
import com.codeminds.temporaly.feature_auth.data.remote.dto.SignUpResponseDto

interface AuthRepository {

    fun signIn(usernameOrEmail: String, password: String, callback: (SignInResponseDto?) -> Unit)

    fun signUp(names: String, lastNames: String, email: String, password: String, roles: List<String>, callback: (SignUpResponseDto?) -> Unit)

    fun refreshToken(refreshToken: String, callback: (RefreshTokenResponseDto?) -> Unit)
}
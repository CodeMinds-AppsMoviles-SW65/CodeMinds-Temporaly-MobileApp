package com.codeminds.temporaly.feature_auth.data.repository

import com.codeminds.temporaly.feature_auth.data.remote.AuthService
import com.codeminds.temporaly.feature_auth.data.remote.dto.RefreshTokenResponseDto
import com.codeminds.temporaly.feature_auth.data.remote.dto.SignInRequestDto
import com.codeminds.temporaly.feature_auth.data.remote.dto.SignInResponseDto
import com.codeminds.temporaly.feature_auth.data.remote.dto.SignUpRequestDto
import com.codeminds.temporaly.feature_auth.data.remote.dto.SignUpResponseDto
import com.codeminds.temporaly.feature_auth.domain.repository.AuthRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthRepositoryImpl(private val authService: AuthService) : AuthRepository {

    override fun signIn(
        usernameOrEmail: String,
        password: String,
        callback: (SignInResponseDto) -> Unit
    ) {
        val request = SignInRequestDto(usernameOrEmail, password)

        authService.signIn(request).enqueue(object : Callback<SignInResponseDto> {

            override fun onResponse(
                call: Call<SignInResponseDto>,
                response: Response<SignInResponseDto>
            ) {
                if (response.isSuccessful) {
                    val signInResponseDto = response.body()
                    if (signInResponseDto != null) {
                        callback(signInResponseDto)
                    }
                }
            }

            override fun onFailure(call: Call<SignInResponseDto>, t: Throwable) {
                // Handle error
            }
        })
    }

    override fun signUp(
        names: String,
        lastNames: String,
        email: String,
        password: String,
        roles: List<String>,
        callback: (SignUpResponseDto) -> Unit
    ) {
        val request = SignUpRequestDto(names, lastNames, email, password, roles)

        authService.signUp(request).enqueue(object : Callback<SignUpResponseDto> {

            override fun onResponse(
                call: Call<SignUpResponseDto>,
                response: Response<SignUpResponseDto>
            ) {
                if (response.isSuccessful) {
                    val signUpResponseDto = response.body()
                    if (signUpResponseDto != null) {
                        callback(signUpResponseDto)
                    }
                }
            }

            override fun onFailure(call: Call<SignUpResponseDto>, t: Throwable) {
                // Handle error
            }
        })

    }

    override fun refreshToken(refreshToken: String, callback: (RefreshTokenResponseDto) -> Unit) {
        authService.refreshToken(refreshToken).enqueue(object : Callback<RefreshTokenResponseDto> {

            override fun onResponse(
                call: Call<RefreshTokenResponseDto>,
                response: Response<RefreshTokenResponseDto>
            ) {
                if (response.isSuccessful) {
                    val refreshTokenResponseDto = response.body()
                    if (refreshTokenResponseDto != null) {
                        callback(refreshTokenResponseDto)
                    }
                }
            }

            override fun onFailure(call: Call<RefreshTokenResponseDto>, t: Throwable) {
                // Handle error
            }
        })
    }
}
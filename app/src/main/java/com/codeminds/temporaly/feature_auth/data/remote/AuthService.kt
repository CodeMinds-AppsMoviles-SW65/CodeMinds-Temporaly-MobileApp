package com.codeminds.temporaly.feature_auth.data.remote

import com.codeminds.temporaly.feature_auth.data.remote.dto.RefreshTokenResponseDto
import com.codeminds.temporaly.feature_auth.data.remote.dto.SignInRequestDto
import com.codeminds.temporaly.feature_auth.data.remote.dto.SignInResponseDto
import com.codeminds.temporaly.feature_auth.data.remote.dto.SignUpRequestDto
import com.codeminds.temporaly.feature_auth.data.remote.dto.SignUpResponseDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface AuthService {

    @POST("authentication/sign-up")
    suspend fun signUp(@Body signUpRequestDto: SignUpRequestDto): Response<SignUpResponseDto>

    @POST("authentication/sign-in")
    suspend fun signIn(@Body signInRequestDto: SignInRequestDto): Response<SignInResponseDto>

    @POST("authentication/refresh-token/{refreshToken}")
    suspend fun refreshToken(@Path("refreshToken") refreshToken: String): Response<RefreshTokenResponseDto>
}
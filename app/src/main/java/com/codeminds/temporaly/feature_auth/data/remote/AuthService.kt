package com.codeminds.temporaly.feature_auth.data.remote

import com.codeminds.temporaly.feature_auth.data.remote.dto.RefreshTokenResponseDto
import com.codeminds.temporaly.feature_auth.data.remote.dto.SignInRequestDto
import com.codeminds.temporaly.feature_auth.data.remote.dto.SignInResponseDto
import com.codeminds.temporaly.feature_auth.data.remote.dto.SignUpRequestDto
import com.codeminds.temporaly.feature_auth.data.remote.dto.SignUpResponseDto
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface AuthService {

    @POST("auth/sign-up")
    fun signUp(@Body signUpRequestDto: SignUpRequestDto): SignUpResponseDto

    @POST("auth/sign-in")
    fun signIn(@Body signInRequestDto: SignInRequestDto): SignInResponseDto

    @POST("auth/refresh-token/{refreshToken}")
    fun refreshToken(@Path("refreshToken") refreshToken: String): RefreshTokenResponseDto
}
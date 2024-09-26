package com.codeminds.temporaly.feature_auth.data.repository

import com.codeminds.temporaly.feature_auth.data.remote.AuthService
import com.codeminds.temporaly.feature_auth.data.remote.dto.RefreshTokenResponseDto
import com.codeminds.temporaly.feature_auth.data.remote.dto.SignInRequestDto
import com.codeminds.temporaly.feature_auth.data.remote.dto.SignInResponseDto
import com.codeminds.temporaly.feature_auth.data.remote.dto.SignUpRequestDto
import com.codeminds.temporaly.feature_auth.data.remote.dto.SignUpResponseDto
import com.codeminds.temporaly.feature_auth.domain.repository.AuthRepository
import kotlinx.coroutines.suspendCancellableCoroutine
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class AuthRepositoryImpl @Inject constructor(private val authService: AuthService) :
    AuthRepository {

    override suspend fun signIn(
        usernameOrEmail: String,
        password: String
    ): SignInResponseDto = suspendCancellableCoroutine { continuation ->
        val request = SignInRequestDto(usernameOrEmail, password)
        val call = authService.signIn(request)
        call.enqueue(object : Callback<SignInResponseDto> {
            override fun onResponse(call: Call<SignInResponseDto>, response: Response<SignInResponseDto>) {
                if (response.isSuccessful) {
                    val signInResponseDto = response.body()
                    if (signInResponseDto != null) {
                        continuation.resume(signInResponseDto)
                    } else {
                        continuation.resumeWithException(Exception("Error"))
                    }
                } else {
                    continuation.resumeWithException(Exception("Error"))
                }
            }

            override fun onFailure(call: Call<SignInResponseDto>, t: Throwable) {
                continuation.resumeWithException(t)
            }
        })

        continuation.invokeOnCancellation {
            call.cancel()
        }
    }

    override suspend fun signUp(
        names: String,
        lastNames: String,
        email: String,
        password: String,
        roles: List<String>,
    ): SignUpResponseDto = suspendCancellableCoroutine { continuation ->
        val request = SignUpRequestDto(names, lastNames, email, password, roles)
        val call = authService.signUp(request)
        call.enqueue(object : Callback<SignUpResponseDto> {
            override fun onResponse(call: Call<SignUpResponseDto>, response: Response<SignUpResponseDto>) {
                if (response.isSuccessful) {
                    val signUpResponseDto = response.body()
                    if (signUpResponseDto != null) {
                        continuation.resume(signUpResponseDto)
                    } else {
                        continuation.resumeWithException(Exception("Error"))
                    }
                } else {
                    continuation.resumeWithException(Exception("Error"))
                }
            }

            override fun onFailure(call: Call<SignUpResponseDto>, t: Throwable) {
                continuation.resumeWithException(t)
            }
        })

        continuation.invokeOnCancellation {
            call.cancel()
        }
    }

    override suspend fun refreshToken(refreshToken: String): RefreshTokenResponseDto = suspendCancellableCoroutine { continuation ->
        val call = authService.refreshToken(refreshToken)
        call.enqueue(object : Callback<RefreshTokenResponseDto> {
            override fun onResponse(call: Call<RefreshTokenResponseDto>, response: Response<RefreshTokenResponseDto>) {
                if (response.isSuccessful) {
                    val refreshTokenResponseDto = response.body()
                    if (refreshTokenResponseDto != null) {
                        continuation.resume(refreshTokenResponseDto)
                    } else {
                        continuation.resumeWithException(Exception("Error"))
                    }
                } else {
                    continuation.resumeWithException(Exception("Error"))
                }
            }

            override fun onFailure(call: Call<RefreshTokenResponseDto>, t: Throwable) {
                continuation.resumeWithException(t)
            }
        })

        continuation.invokeOnCancellation {
            call.cancel()
        }
    }
}
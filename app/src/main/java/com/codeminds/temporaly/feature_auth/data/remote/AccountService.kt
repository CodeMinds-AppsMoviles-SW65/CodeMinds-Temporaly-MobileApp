package com.codeminds.temporaly.feature_auth.data.remote

import com.codeminds.temporaly.feature_auth.data.remote.dto.AccountDto
import retrofit2.http.POST
import retrofit2.http.Path

interface AccountService {

    @POST("account/{username}")
    fun getAccount(@Path("username") username: String): AccountDto
}
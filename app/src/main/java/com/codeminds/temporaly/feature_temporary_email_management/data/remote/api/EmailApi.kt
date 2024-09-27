package com.codeminds.temporaly.feature_temporary_email_management.data.remote.api

import org.json.JSONObject
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface EmailApi {
    @GET
    suspend fun fetchJsonData(@Url url: String): Response<JSONObject>
}
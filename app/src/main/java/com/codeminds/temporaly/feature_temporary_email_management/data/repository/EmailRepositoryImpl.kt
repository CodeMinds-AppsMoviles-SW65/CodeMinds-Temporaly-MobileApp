package com.codeminds.temporaly.feature_temporary_email_management.data.repository

import com.codeminds.temporaly.feature_temporary_email_management.data.remote.api.EmailApi
import com.codeminds.temporaly.feature_temporary_email_management.domain.repository.EmailRepository
import org.json.JSONObject
import retrofit2.Response

//class EmailRepositoryImpl(
//    private val apiService: EmailApi
//) : EmailRepository {
//    override suspend fun fetchJsonData(url: String): Result<JSONObject> {
//        return try {
//            val response: Response<String> = apiService.fetchJsonData(url)
//            if (response.isSuccessful) {
//                response.body()?.let {
//                    Result.success(JSONObject(it))
//                } ?: Result.failure(Exception("Empty response body"))
//            } else {
//                Result.failure(Exception("API Error: ${response.code()}"))
//            }
//        } catch (e: Exception) {
//            Result.failure(e)
//        }
//    }
//}
package com.codeminds.temporaly.feature_temporary_email_management.domain.repository

import com.codeminds.temporaly.feature_temporary_email_management.data.local.entity.UserCredentialsEntity

interface UserCredentialsRepository {
    suspend fun insertUserCredentials(email: String, token: String)
    suspend fun deleteUserCredentials(email: String)
    suspend fun getAllUserCredentials(): List<UserCredentialsEntity>
}
package com.codeminds.temporaly.feature_temporary_email_management.data.repository

import com.codeminds.temporaly.feature_temporary_email_management.data.local.dao.UserCredentialsDao
import com.codeminds.temporaly.feature_temporary_email_management.data.local.entity.UserCredentialsEntity
import com.codeminds.temporaly.feature_temporary_email_management.domain.repository.UserCredentialsRepository

class UserCredentialRepositoryImpl (
    private val dao: UserCredentialsDao
) : UserCredentialsRepository {
    override suspend fun insertUserCredentials(email: String, token: String) {
        dao.insertUserCredentials(UserCredentialsEntity(email, token))
    }

    override suspend fun deleteUserCredentials(email: String) {
        val credentials = dao.getAllUserCredentials().find { it.email == email }
        credentials?.let { dao.deleteUserCredentials(it) }
    }

    override suspend fun getAllUserCredentials(): List<UserCredentialsEntity> {
        return dao.getAllUserCredentials()
    }
}
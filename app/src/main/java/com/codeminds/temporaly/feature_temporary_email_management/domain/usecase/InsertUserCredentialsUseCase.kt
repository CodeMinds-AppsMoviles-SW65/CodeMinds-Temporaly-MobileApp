package com.codeminds.temporaly.feature_temporary_email_management.domain.usecase

import com.codeminds.temporaly.feature_temporary_email_management.domain.repository.UserCredentialsRepository

class InsertUserCredentialsUseCase(private val repository: UserCredentialsRepository) {
    suspend operator fun invoke(email: String, token: String) {
        repository.insertUserCredentials(email, token)
    }
}
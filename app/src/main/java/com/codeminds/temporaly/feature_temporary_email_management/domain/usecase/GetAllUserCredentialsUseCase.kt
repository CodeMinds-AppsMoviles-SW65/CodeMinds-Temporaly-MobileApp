package com.codeminds.temporaly.feature_temporary_email_management.domain.usecase

import com.codeminds.temporaly.feature_temporary_email_management.data.local.entity.UserCredentialsEntity
import com.codeminds.temporaly.feature_temporary_email_management.domain.repository.UserCredentialsRepository

class GetAllUserCredentialsUseCase(private val repository: UserCredentialsRepository) {
    suspend operator fun invoke(): List<UserCredentialsEntity> {
        return repository.getAllUserCredentials()
    }
}
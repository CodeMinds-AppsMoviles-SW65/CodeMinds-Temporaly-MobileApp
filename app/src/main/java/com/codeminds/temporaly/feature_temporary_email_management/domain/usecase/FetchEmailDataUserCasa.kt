package com.codeminds.temporaly.feature_temporary_email_management.domain.usecase

import com.codeminds.temporaly.feature_temporary_email_management.domain.repository.EmailRepository
import org.json.JSONObject

class FetchJsonDataUseCase(private val repository: EmailRepository) {
//    suspend operator fun invoke(url: String): Result<JSONObject> {
//        return repository.fetchJsonData(url)
//    }
}
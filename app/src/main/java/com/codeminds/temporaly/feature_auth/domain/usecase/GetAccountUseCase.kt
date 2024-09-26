package com.codeminds.temporaly.feature_auth.domain.usecase

import com.codeminds.temporaly.core.utils.Resource
import com.codeminds.temporaly.feature_auth.domain.model.Account
import com.codeminds.temporaly.feature_auth.domain.repository.AccountRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAccountUseCase @Inject constructor(private val accountRepository: AccountRepository) {

    operator fun invoke(username: String): Flow<Resource<Account>> = flow {
        try {
            emit(Resource.Loading())
            val account = accountRepository.getAccount(username)
            emit(Resource.Success(data = account))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "Unknown Error"))
        }
    }
}
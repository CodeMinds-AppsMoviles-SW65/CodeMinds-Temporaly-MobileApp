package com.codeminds.temporaly.feature_auth.domain.usecase

import com.codeminds.temporaly.core.utils.Resource
import com.codeminds.temporaly.feature_auth.domain.model.Account
import com.codeminds.temporaly.feature_auth.domain.repository.AccountRepository

class GetAccountUseCase(private val accountRepository: AccountRepository) {

    operator fun invoke(username: String, callback: (Resource<Account>) -> Unit) {
        callback(Resource.Loading())
        accountRepository.getAccount(username) { account ->
            if (account != null) {
                callback(Resource.Success(account))
            } else {
                callback(Resource.Error("An error occurred"))
            }
        }
    }
}
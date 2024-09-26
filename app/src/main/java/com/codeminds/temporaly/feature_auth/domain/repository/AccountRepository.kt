package com.codeminds.temporaly.feature_auth.domain.repository

import com.codeminds.temporaly.feature_auth.domain.model.Account

interface AccountRepository {

    suspend fun getAccount(username: String): Account

    suspend fun getLocalAccount(): Pair<Account, String>
}
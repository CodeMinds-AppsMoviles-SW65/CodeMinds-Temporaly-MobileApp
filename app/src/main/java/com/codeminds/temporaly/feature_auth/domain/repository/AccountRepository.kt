package com.codeminds.temporaly.feature_auth.domain.repository

import com.codeminds.temporaly.feature_auth.domain.model.Account

interface AccountRepository {

    fun getAccount(username: String, callback: (Account?) -> Unit)

}
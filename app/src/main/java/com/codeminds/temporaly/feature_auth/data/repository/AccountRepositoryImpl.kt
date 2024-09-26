package com.codeminds.temporaly.feature_auth.data.repository

import com.codeminds.temporaly.feature_auth.data.remote.AccountService
import com.codeminds.temporaly.feature_auth.data.remote.dto.AccountDto
import com.codeminds.temporaly.feature_auth.data.remote.dto.toAccount
import com.codeminds.temporaly.feature_auth.domain.model.Account
import com.codeminds.temporaly.feature_auth.domain.repository.AccountRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AccountRepositoryImpl(private val accountService: AccountService) : AccountRepository {

    override fun getAccount(username: String, callback: (Account?) -> Unit) {

        accountService.getAccount(username).enqueue(object : Callback<AccountDto> {

            override fun onResponse(call: Call<AccountDto>, response: Response<AccountDto>) {
                if (response.isSuccessful) {
                    val accountDto = response.body()
                    if (accountDto != null) {
                        callback(accountDto.toAccount())
                    }
                }
            }

            override fun onFailure(call: Call<AccountDto>, t: Throwable) {
                callback(null) // Handle error
            }
        })
    }
}
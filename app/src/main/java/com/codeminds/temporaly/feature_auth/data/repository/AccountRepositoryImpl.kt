package com.codeminds.temporaly.feature_auth.data.repository

import com.codeminds.temporaly.feature_auth.data.local.dao.LocalAccountDao
import com.codeminds.temporaly.feature_auth.data.local.entity.toAccount
import com.codeminds.temporaly.feature_auth.data.remote.AccountService
import com.codeminds.temporaly.feature_auth.data.remote.dto.AccountDto
import com.codeminds.temporaly.feature_auth.data.remote.dto.toAccount
import com.codeminds.temporaly.feature_auth.domain.model.Account
import com.codeminds.temporaly.feature_auth.domain.repository.AccountRepository
import kotlinx.coroutines.suspendCancellableCoroutine
import retrofit2.Call
import javax.inject.Inject
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class AccountRepositoryImpl @Inject constructor(
    private val accountService: AccountService,
    private val accountDao: LocalAccountDao
) :
    AccountRepository {

    override suspend fun getAccount(username: String): Account =
        suspendCancellableCoroutine { continuation ->
            val call = accountService.getAccount(username)
            call.enqueue(object : Callback<AccountDto> {
                override fun onResponse(call: Call<AccountDto>, response: Response<AccountDto>) {
                    if (response.isSuccessful) {
                        val accountDto = response.body()
                        if (accountDto != null) {
                            continuation.resume(accountDto.toAccount())
                        } else {
                            continuation.resumeWithException(Exception("Error"))
                        }
                    } else {
                        continuation.resumeWithException(Exception("Error"))
                    }
                }

                override fun onFailure(call: Call<AccountDto>, t: Throwable) {
                    continuation.resumeWithException(t)
                }
            })

            continuation.invokeOnCancellation {
                call.cancel()
            }
        }

    override suspend fun getLocalAccount(): Pair<Account, String> {
        val account = accountDao.getAccount()
        return if (account != null) {
            Pair(account.toAccount(), account.token)
        } else {
            Pair(Account("", "", ""), "Error")
        }
    }
}
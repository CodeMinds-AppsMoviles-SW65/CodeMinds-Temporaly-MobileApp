package com.codeminds.temporaly.feature_temporary_email_management.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codeminds.temporaly.feature_temporary_email_management.data.local.entity.UserCredentialsEntity
import com.codeminds.temporaly.feature_temporary_email_management.domain.usecase.DeleteUserCredentialsUseCase
import com.codeminds.temporaly.feature_temporary_email_management.domain.usecase.GetAllUserCredentialsUseCase
import com.codeminds.temporaly.feature_temporary_email_management.domain.usecase.InsertUserCredentialsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UserCredentialsViewModel(
    private val insertUserCredentialsUseCase: InsertUserCredentialsUseCase,
    private val deleteUserCredentialsUseCase: DeleteUserCredentialsUseCase,
    private val getAllUserCredentialsUseCase: GetAllUserCredentialsUseCase
) : ViewModel() {

    private val _credentialsList = MutableStateFlow<List<UserCredentialsEntity>>(emptyList())
    val credentialsList = _credentialsList.asStateFlow()

    fun insertUserCredentials(email: String, token: String) {
        viewModelScope.launch {
            insertUserCredentialsUseCase(email, token)
            fetchUserCredentials()
        }
    }

    fun deleteUserCredentials(email: String) {
        viewModelScope.launch {
            deleteUserCredentialsUseCase(email)
            fetchUserCredentials()
        }
    }

    fun fetchUserCredentials() {
        viewModelScope.launch {
            _credentialsList.value = getAllUserCredentialsUseCase()
        }
    }
}
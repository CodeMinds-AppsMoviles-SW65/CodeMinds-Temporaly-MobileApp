package com.codeminds.temporaly.feature_auth.presentation.sign_in.render

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codeminds.temporaly.core.utils.Resource
import com.codeminds.temporaly.core.utils.ViewModelState
import com.codeminds.temporaly.feature_auth.data.remote.dto.toAccount
import com.codeminds.temporaly.feature_auth.domain.model.Account
import com.codeminds.temporaly.feature_auth.domain.usecase.SignInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * Created by Alex Avila Asto - A.K.A (Ryzeon)
 * Project: Temporaly
 * Date: 26/09/24 @ 15:28
 */
@HiltViewModel
class SignInViewModel @Inject constructor(private val signInUseCase: SignInUseCase) : ViewModel() {

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> get() = _email

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> get() = _password

    private val _state = MutableStateFlow(ViewModelState<Account>())
    val state: StateFlow<ViewModelState<Account>> get() = _state

    fun onEmailChanged(email: String) {
        _email.value = email
    }

    fun onPasswordChanged(password: String) {
        _password.value = password
    }

    fun signIn() {
        signInUseCase(_email.value, _password.value).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = ViewModelState(isLoading = true)
                }
                is Resource.Loading -> {
                    _state.value = ViewModelState(data = result.data?.toAccount())
                }
                is Resource.Error -> {
                    _state.value = ViewModelState(error = result.message)
                }
            }
        }.launchIn(viewModelScope)
    }
}
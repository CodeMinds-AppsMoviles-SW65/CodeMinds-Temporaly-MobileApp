package com.codeminds.temporaly.feature_auth.presentation.sign_up.render

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codeminds.temporaly.core.utils.Resource
import com.codeminds.temporaly.core.utils.ViewModelState
import com.codeminds.temporaly.feature_auth.domain.usecase.SignUpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * Created by Alex Avila Asto - A.K.A (Ryzeon)
 * Project: Temporaly
 * Date: 27/09/24 @ 00:09
 */
@HiltViewModel
class SignUpViewModel @Inject constructor(private val signUpUseCase: SignUpUseCase):
    ViewModel() {

    private val _username = MutableStateFlow("")
    val username: StateFlow<String> get() = _username

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> get() = _email

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> get() = _password

    private val _state = MutableStateFlow(ViewModelState<Void>())
    val state: StateFlow<ViewModelState<Void>> get() = _state

    fun onUsernameChanged(username: String) {
        _username.value = username
    }

    fun onEmailChanged(email: String) {
        _email.value = email
    }

    fun onPasswordChanged(password: String) {
        _password.value = password
    }

    fun signUp() {
        signUpUseCase(_username.value, _email.value, _password.value).onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = ViewModelState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = ViewModelState(success = true, data = null)
                }
                is Resource.Error -> {
                    _state.value = ViewModelState(error = result.message?:"Can't sign up")
                }
            }
        }.launchIn(viewModelScope)
    }

    fun clearError() {
        _state.value = ViewModelState()
    }
}
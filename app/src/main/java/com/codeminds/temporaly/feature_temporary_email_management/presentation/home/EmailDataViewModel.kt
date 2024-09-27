package com.codeminds.temporaly.feature_temporary_email_management.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codeminds.temporaly.feature_temporary_email_management.domain.usecase.FetchJsonDataUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.json.JSONObject

//sealed class JsonDataState {
//    object Loading : JsonDataState()
//    data class Success(val data: JSONObject) : JsonDataState()
//    data class Error(val message: String) : JsonDataState()
//}
//
//class EmailDataViewModel(private val fetchJsonDataUseCase: FetchJsonDataUseCase) : ViewModel() {
//    private val _jsonDataState = MutableStateFlow<JsonDataState>(JsonDataState.Loading)
//    val jsonDataState = _jsonDataState.asStateFlow()

//    fun fetchJsonData(url: String) {
//        viewModelScope.launch {
//            _jsonDataState.value = JsonDataState.Loading
//            val result = fetchJsonDataUseCase(url)
//            _jsonDataState.value = result.fold(
//                onSuccess = { JsonDataState.Success(it) },
//                onFailure = { JsonDataState.Error(it.localizedMessage ?: "Unknown error") }
//            )
//        }
//    }
//}
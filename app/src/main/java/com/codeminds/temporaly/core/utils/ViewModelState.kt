package com.codeminds.temporaly.core.utils

/**
 * Created by Alex Avila Asto - A.K.A (Ryzeon)
 * Project: Temporaly
 * Date: 26/09/24 @ 15:24
 */
data class ViewModelState<T> (
    val isLoading: Boolean = false,
    val data : T? = null,
    val error: String = ""
)

package com.jujodevs.dogedex.core.networks

sealed class ApiResponseStatus<T> {
    data class Success<T>(val data: T?): ApiResponseStatus<T>()
    class Loading<T>: ApiResponseStatus<T>()
    data class Error<T>(val messageId: Int): ApiResponseStatus<T>()
}
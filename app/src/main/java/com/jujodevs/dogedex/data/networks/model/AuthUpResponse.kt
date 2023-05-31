package com.jujodevs.dogedex.data.networks.model

import com.google.gson.annotations.SerializedName

data class AuthUpResponse (
    @SerializedName("message")
    val message: String,
    @SerializedName("is_success")
    val isSuccess: Boolean,
    @SerializedName("data")
    val data: DataSignUpResponse?
)

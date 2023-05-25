package com.jujodevs.dogedex.data.network.model


import com.google.gson.annotations.SerializedName

data class DogListResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("is_success")
    val isSuccess: Boolean,
    @SerializedName("data")
    val data: DataDogListResponse
)
package com.jujodevs.dogedex.data.network.model


import com.google.gson.annotations.SerializedName

data class DataDogListResponse(
    @SerializedName("dogs")
    val dogs: List<DogResponse>
)
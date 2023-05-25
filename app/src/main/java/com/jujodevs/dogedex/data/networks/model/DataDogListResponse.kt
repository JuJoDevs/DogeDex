package com.jujodevs.dogedex.data.networks.model


import com.google.gson.annotations.SerializedName

data class DataDogListResponse(
    @SerializedName("dogs")
    val dogs: List<DogResponse>
)
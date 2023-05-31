package com.jujodevs.dogedex.data.networks.model


import com.google.gson.annotations.SerializedName
import com.jujodevs.dogedex.data.networks.model.dto.DogDTO

data class DataDogListResponse(
    @SerializedName("dogs")
    val dogs: List<DogDTO>
)
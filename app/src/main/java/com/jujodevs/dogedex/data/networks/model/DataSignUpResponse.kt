package com.jujodevs.dogedex.data.networks.model


import com.google.gson.annotations.SerializedName
import com.jujodevs.dogedex.data.networks.model.dto.UserDTO

data class DataSignUpResponse(
    @SerializedName("user")
    val user: UserDTO
)
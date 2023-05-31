package com.jujodevs.dogedex.data.networks.model.dto

import com.google.gson.annotations.SerializedName

data class UserDTO(
    @SerializedName("id") val id: Long,
    @SerializedName("email") val email: String,
    @SerializedName("authentication_token") val authenticationToken: String
)

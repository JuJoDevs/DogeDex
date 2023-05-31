package com.jujodevs.dogedex.data.networks.model.dto

import com.google.gson.annotations.SerializedName
import com.jujodevs.dogedex.domain.model.Login

data class LoginDTO (
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String
)

fun Login.toDTO() = LoginDTO(email, password)
package com.jujodevs.dogedex.data.networks.model.dto

import com.google.gson.annotations.SerializedName
import com.jujodevs.dogedex.domain.model.SignUp

data class SignUpDTO (
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String,
    @SerializedName("password_confirmation") val passwordConfirmation: String
)

fun SignUp.toDTO() = SignUpDTO(email, password, passwordConfirmation)
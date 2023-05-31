package com.jujodevs.dogedex.domain.model

data class SignUp (
    val email: String,
    val password: String,
    val passwordConfirmation: String
)
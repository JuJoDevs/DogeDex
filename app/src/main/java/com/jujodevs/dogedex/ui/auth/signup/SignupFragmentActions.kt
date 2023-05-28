package com.jujodevs.dogedex.ui.auth.signup

interface SignupFragmentActions {
    fun onSignUpFieldsValidated(email: String, password: String, passwordConfirmation: String)
}
package com.jujodevs.dogedex.ui.auth.signup

import com.jujodevs.dogedex.domain.model.SignUp

interface SignupFragmentActions {
    fun onSignUpFieldsValidated(signUp: SignUp)
}
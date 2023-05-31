package com.jujodevs.dogedex.ui.auth.login

import com.jujodevs.dogedex.domain.model.Login

interface LoginFragmentActions {
    fun onRegisterButtonClick()
    fun onLoginFieldsValidated(login: Login)
}
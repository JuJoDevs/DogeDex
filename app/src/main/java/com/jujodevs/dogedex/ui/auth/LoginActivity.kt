package com.jujodevs.dogedex.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.jujodevs.dogedex.R
import com.jujodevs.dogedex.databinding.ActivityLoginBinding
import com.jujodevs.dogedex.ui.auth.login.LoginFragmentActions
import com.jujodevs.dogedex.ui.auth.login.LoginFragmentDirections
import com.jujodevs.dogedex.ui.auth.signup.SignupFragmentActions
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity(), LoginFragmentActions, SignupFragmentActions {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onRegisterButtonClick() {
        findNavController(R.id.nav_host_fragment)
            .navigate(LoginFragmentDirections.actionLoginFragmentToSignupFragment())
    }

    override fun onSignUpFieldsValidated(
        email: String,
        password: String,
        passwordConfirmation: String
    ) {
        TODO("Not yet implemented")
    }
}
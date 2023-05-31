package com.jujodevs.dogedex.ui.auth

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.jujodevs.dogedex.R
import com.jujodevs.dogedex.core.networks.ApiResponseStatus
import com.jujodevs.dogedex.databinding.ActivityLoginBinding
import com.jujodevs.dogedex.domain.model.Login
import com.jujodevs.dogedex.domain.model.SignUp
import com.jujodevs.dogedex.domain.model.User
import com.jujodevs.dogedex.ui.auth.login.LoginFragmentActions
import com.jujodevs.dogedex.ui.auth.login.LoginFragmentDirections
import com.jujodevs.dogedex.ui.auth.signup.SignupFragmentActions
import com.jujodevs.dogedex.ui.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity(), LoginFragmentActions, SignupFragmentActions {

    companion object{
        fun create(context: Context) = Intent(context, LoginActivity::class.java)
    }

    private val viewModel by viewModels<AuthViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.status.observe(this) { status ->
            when (status) {
                is ApiResponseStatus.Error -> {
                    binding.loadingWheel.visibility = View.GONE
                    showErrorDialog(status.messageId)
                }

                is ApiResponseStatus.Loading -> {
                    binding.loadingWheel.visibility = View.VISIBLE
                }

                is ApiResponseStatus.Success -> {
                    binding.loadingWheel.visibility = View.GONE
                }
            }
        }

        viewModel.user.observe(this){ user ->
            if (user != null){
                User.setLoggedInUser(this, user)
                startMainActivity()
            }
        }
    }

    private fun startMainActivity() {
        startActivity(MainActivity.create(this))
        finish()
    }

    private fun showErrorDialog(messageId: Int){
        AlertDialog.Builder(this)
            .setTitle(R.string.there_was_an_error)
            .setMessage(messageId)
            .setPositiveButton(android.R.string.ok, null)
            .create()
            .show()
    }

    override fun onRegisterButtonClick() {
        findNavController(R.id.nav_host_fragment)
            .navigate(LoginFragmentDirections.actionLoginFragmentToSignupFragment())
    }

    override fun onLoginFieldsValidated(login: Login) {
        viewModel.login(login)
    }

    override fun onSignUpFieldsValidated(signUp: SignUp) {
        viewModel.signUp(signUp)
    }
}
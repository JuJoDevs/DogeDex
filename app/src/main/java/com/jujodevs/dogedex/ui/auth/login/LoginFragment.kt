package com.jujodevs.dogedex.ui.auth.login

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jujodevs.dogedex.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import java.lang.ClassCastException

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private lateinit var loginFragmentActions: LoginFragmentActions

    override fun onAttach(context: Context) {
        super.onAttach(context)
        loginFragmentActions = try {
            context as LoginFragmentActions
        } catch (e: ClassCastException){
            throw ClassCastException("$context must implement LoginFragmentActions")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentLoginBinding.inflate(inflater)
        binding.loginRegisterButton.setOnClickListener {
            loginFragmentActions.onRegisterButtonClick()
        }
        return binding.root
    }

}
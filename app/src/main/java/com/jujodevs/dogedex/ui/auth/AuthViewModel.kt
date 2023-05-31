package com.jujodevs.dogedex.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jujodevs.dogedex.core.networks.ApiResponseStatus
import com.jujodevs.dogedex.data.AuthRepository
import com.jujodevs.dogedex.domain.model.Login
import com.jujodevs.dogedex.domain.model.SignUp
import com.jujodevs.dogedex.domain.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(private val authRepository: AuthRepository): ViewModel() {

    private val _user = MutableLiveData<User>()
    val user: LiveData<User> get() = _user

    private val _status = MutableLiveData<ApiResponseStatus<User>>()
    val status: LiveData<ApiResponseStatus<User>> get() = _status

    fun signUp(signUp: SignUp){
        viewModelScope.launch {
            _status.value = ApiResponseStatus.Loading()
            handleResponseStatus(authRepository.signUp(signUp))
        }
    }

    private fun handleResponseStatus(apiResponseStatus: ApiResponseStatus<User>){
        if (apiResponseStatus is ApiResponseStatus.Success){
            apiResponseStatus.data?.let {
                _user.value = it
            }
        }
        _status.value = apiResponseStatus
    }

    fun login(login: Login) {
        viewModelScope.launch {
            _status.value = ApiResponseStatus.Loading()
            handleResponseStatus(authRepository.login(login))
        }
    }
}
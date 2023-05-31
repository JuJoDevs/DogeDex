package com.jujodevs.dogedex.data

import com.jujodevs.dogedex.core.networks.ApiResponseStatus
import com.jujodevs.dogedex.data.networks.ToDogsApi
import com.jujodevs.dogedex.data.networks.model.dto.toDTO
import com.jujodevs.dogedex.domain.model.Login
import com.jujodevs.dogedex.domain.model.SignUp
import com.jujodevs.dogedex.domain.model.User
import com.jujodevs.dogedex.domain.model.toDomain
import javax.inject.Inject


class AuthRepository @Inject constructor(private val toDogsApi: ToDogsApi): BaseRepository() {

    suspend fun login(login: Login): ApiResponseStatus<User> =
        makeNetworkCall {
            val response = toDogsApi.login(login.toDTO())

            if (!response.isSuccess) {
                throw Exception(response.message)
            }

            response.data!!.user.toDomain()
        }


    suspend fun signUp(signUp: SignUp): ApiResponseStatus<User> =
            makeNetworkCall {
                val response = toDogsApi.signUp(signUp.toDTO())

                if (!response.isSuccess) {
                    throw Exception(response.message)
                }

                response.data!!.user.toDomain()
            }

}
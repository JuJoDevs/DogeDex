package com.jujodevs.dogedex.data.networks

import com.jujodevs.dogedex.GET_ALL_DOGS_URL
import com.jujodevs.dogedex.SIGN_IN_URL
import com.jujodevs.dogedex.SIGN_UP_URL
import com.jujodevs.dogedex.data.networks.model.AuthUpResponse
import com.jujodevs.dogedex.data.networks.model.DogListResponse
import com.jujodevs.dogedex.data.networks.model.dto.LoginDTO
import com.jujodevs.dogedex.data.networks.model.dto.SignUpDTO
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ToDogsApi {

    @GET(GET_ALL_DOGS_URL)
    suspend fun getAllDogs(): DogListResponse

    @POST(SIGN_UP_URL)
    suspend fun signUp(@Body signUpDTO: SignUpDTO): AuthUpResponse

    @POST(SIGN_IN_URL)
    suspend fun login(@Body loginDTO: LoginDTO): AuthUpResponse


}
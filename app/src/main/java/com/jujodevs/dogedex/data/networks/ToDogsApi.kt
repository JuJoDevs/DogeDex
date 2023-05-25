package com.jujodevs.dogedex.data.networks

import com.jujodevs.dogedex.GET_ALL_DOGS_URL
import com.jujodevs.dogedex.data.networks.model.DogListResponse
import retrofit2.http.GET

interface ToDogsApi {

    @GET(GET_ALL_DOGS_URL)
    suspend fun getAllDogs(): DogListResponse

}
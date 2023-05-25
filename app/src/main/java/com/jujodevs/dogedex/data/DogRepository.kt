package com.jujodevs.dogedex.data

import com.jujodevs.dogedex.core.networks.ApiResponseStatus
import com.jujodevs.dogedex.data.networks.BaseRepository
import com.jujodevs.dogedex.data.networks.ToDogsApi
import com.jujodevs.dogedex.domain.model.Dog
import com.jujodevs.dogedex.domain.model.toDomain
import javax.inject.Inject

class DogRepository @Inject constructor(private val toDogsApi: ToDogsApi): BaseRepository() {

    suspend fun downloadDogs(): ApiResponseStatus<List<Dog>> =
        makeNetworkCall { toDogsApi.getAllDogs().data.dogs.map { it.toDomain() } }

}
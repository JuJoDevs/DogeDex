package com.jujodevs.dogedex.data

import com.jujodevs.dogedex.data.network.ToDogsApi
import com.jujodevs.dogedex.domain.model.Dog
import com.jujodevs.dogedex.domain.model.toDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DogRepository @Inject constructor(private val toDogsApi: ToDogsApi) {

    suspend fun downloadDogs(): List<Dog> {
        return withContext(Dispatchers.IO) {
            toDogsApi.getAllDogs().data.dogs.map { it.toDomain() }
        }
    }

}
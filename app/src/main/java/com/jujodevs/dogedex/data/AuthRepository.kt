package com.jujodevs.dogedex.data

import com.jujodevs.dogedex.data.network.ToDogsApi
import com.jujodevs.dogedex.domain.model.Dog
import com.jujodevs.dogedex.domain.model.toDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class AuthRepository @Inject constructor(private val toDogsApi: ToDogsApi) {

    suspend fun signUp(email: String, password: String, passwordConfirmation: String): List<Dog> {
        return withContext(Dispatchers.IO) {
            toDogsApi.getAllDogs().data.dogs.map { it.toDomain() }
        }
    }

}
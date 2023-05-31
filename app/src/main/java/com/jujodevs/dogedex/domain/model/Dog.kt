package com.jujodevs.dogedex.domain.model

import android.os.Parcelable
import com.jujodevs.dogedex.data.networks.model.dto.DogDTO
import kotlinx.parcelize.Parcelize

@Parcelize
data class Dog(
    val id: Long,
    val index: Int,
    val name: String,
    val type: String,
    val heightFemale: String,
    val heightMale: String,
    val imageUrl: String,
    val lifeExpectancy: String,
    val temperament: String,
    val weightFemale: String,
    val weightMale: String
) : Parcelable

fun DogDTO.toDomain() =
    Dog(
        id.toLong(),
        index,
        nameEs,
        dogType,
        heightFemale,
        heightMale,
        imageUrl,
        lifeExpectancy,
        temperament,
        weightFemale,
        weightMale
    )
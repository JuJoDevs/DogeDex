package com.jujodevs.dogedex.data.networks.model.dto


import com.google.gson.annotations.SerializedName

data class DogDTO(
    @SerializedName("id")
    val id: Int,
    @SerializedName("dog_type")
    val dogType: String,
    @SerializedName("height_female")
    val heightFemale: String,
    @SerializedName("height_male")
    val heightMale: String,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("index")
    val index: Int,
    @SerializedName("life_expectancy")
    val lifeExpectancy: String,
    @SerializedName("name_en")
    val nameEn: String,
    @SerializedName("name_es")
    val nameEs: String,
    @SerializedName("temperament")
    val temperament: String,
    @SerializedName("temperament_en")
    val temperamentEn: String,
    @SerializedName("weight_female")
    val weightFemale: String,
    @SerializedName("weight_male")
    val weightMale: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("ml_id")
    val mlId: String
)
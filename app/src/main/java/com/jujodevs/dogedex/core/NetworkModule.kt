package com.jujodevs.dogedex.core

import com.jujodevs.dogedex.BASE_URL
import com.jujodevs.dogedex.data.networks.ToDogsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideToDogsAPI(retrofit: Retrofit): ToDogsApi =
        retrofit.create(ToDogsApi::class.java)
}
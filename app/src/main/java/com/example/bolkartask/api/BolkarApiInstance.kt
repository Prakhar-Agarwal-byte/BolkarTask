package com.example.bolkartask.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BolkarApiInstance {
    private const val BASE_URL = "https://api.bolkarapp.com"

    val api: BolkarApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BolkarApiService::class.java)
    }
}
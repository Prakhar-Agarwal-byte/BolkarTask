package com.example.bolkartask.api

import com.example.bolkartask.models.RoomResponse
import retrofit2.Response
import retrofit2.http.GET

interface BolkarApiService {
    @GET("/live/room.json")
    suspend fun getRoomDetails(): Response<RoomResponse>
}
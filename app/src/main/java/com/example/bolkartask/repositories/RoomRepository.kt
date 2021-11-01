package com.example.bolkartask.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.bolkartask.api.BolkarApiService
import com.example.bolkartask.models.RoomData

class RoomRepository(private val bolkarApiService: BolkarApiService) {

    private val _roomDetails = MutableLiveData<RoomData>()
    val roomDetails: LiveData<RoomData>
    get() = _roomDetails

    suspend fun getRoomDetails() {
        val result = bolkarApiService.getRoomDetails()
        if (result?.body() != null) {
            _roomDetails.postValue(result.body()!!.data)
        }
    }
}
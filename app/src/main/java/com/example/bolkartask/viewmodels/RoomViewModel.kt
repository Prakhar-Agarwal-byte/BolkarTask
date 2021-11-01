package com.example.bolkartask.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bolkartask.models.Member
import com.example.bolkartask.models.RoomData
import com.example.bolkartask.repositories.RoomRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RoomViewModel(private val repository: RoomRepository) : ViewModel() {

    val roomDetails: LiveData<RoomData>
        get() = repository.roomDetails

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getRoomDetails()
        }
    }

    val roomHost = Transformations.map(roomDetails) {
        it.host
    }

    val roomModerators = Transformations.map(roomDetails) {
        it.moderators
    }

    val roomSpeakers = Transformations.map(roomDetails) {
        it.speakers
    }

    val roomMembers = Transformations.map(roomDetails) {
        it.members
    }

    val totalMembers = Transformations.map(roomDetails) {
        it.total_members
    }
}
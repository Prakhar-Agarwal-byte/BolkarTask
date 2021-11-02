package com.example.bolkartask.viewmodels

import androidx.lifecycle.*
import com.example.bolkartask.models.Member
import com.example.bolkartask.models.RoomData
import com.example.bolkartask.repositories.RoomRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RoomViewModel(private val repository: RoomRepository) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getRoomDetails()
        }
    }

    val roomDetails = Transformations.map(repository.roomDetails) {
        it.host.role = "host"
        it.members.forEach {
            it.role = "member"
        }
        it.speakers.forEach {
            it.role = "speaker"
        }
        it.moderators.forEach {
            it.role = "mod"
        }
        return@map it
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

    val hostAndSpeakers = Transformations.map(roomDetails) {
        val res =  ArrayList<Member>()
        res.add(it.host)
        res.addAll(it.speakers)
        return@map res
    }
}
package com.example.bolkartask.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bolkartask.repositories.RoomRepository

class RoomViewModelFactory(private val repository: RoomRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return RoomViewModel(repository) as T
    }

}
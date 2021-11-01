package com.example.bolkartask.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bolkartask.R
import com.example.bolkartask.api.BolkarApiInstance
import com.example.bolkartask.databinding.ActivityMainBinding
import com.example.bolkartask.repositories.RoomRepository
import com.example.bolkartask.viewmodels.RoomViewModel
import com.example.bolkartask.viewmodels.RoomViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var roomViewModel: RoomViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val repository = RoomRepository(BolkarApiInstance.api)
        roomViewModel = ViewModelProvider(this, RoomViewModelFactory(repository)).get(RoomViewModel::class.java)

        binding.roomViewModel = roomViewModel
        binding.lifecycleOwner = this

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

}
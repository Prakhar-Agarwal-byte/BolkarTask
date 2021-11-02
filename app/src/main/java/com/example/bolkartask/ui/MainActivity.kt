package com.example.bolkartask.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.bolkartask.R
import com.example.bolkartask.api.BolkarApiInstance
import com.example.bolkartask.databinding.ActivityMainBinding
import com.example.bolkartask.models.Member
import com.example.bolkartask.repositories.RoomRepository
import com.example.bolkartask.ui.adapters.MembersAdapter
import com.example.bolkartask.viewmodels.RoomViewModel
import com.example.bolkartask.viewmodels.RoomViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var roomViewModel: RoomViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val repository = RoomRepository(BolkarApiInstance.api)
        roomViewModel = ViewModelProvider(this, RoomViewModelFactory(repository))[RoomViewModel::class.java]

        binding.roomViewModel = roomViewModel
        binding.lifecycleOwner = this

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val rvElevatedMembers = binding.rvElevatedMembers
        rvElevatedMembers.layoutManager = GridLayoutManager(this, 3)
        val membersAdapter1 = MembersAdapter("elevatedMembers")
        rvElevatedMembers.adapter = membersAdapter1

        roomViewModel.hostAndSpeakers.observe(this, {
            it?.let {
                membersAdapter1.setData(it)
            }
        })

        val rvMembers = binding.rvMembers
        rvMembers.layoutManager = GridLayoutManager(this, 4)
        val membersAdapter2 = MembersAdapter("members")
        rvMembers.adapter = membersAdapter2

        roomViewModel.roomMembers.observe(this, {
            it?.let {
                membersAdapter2.setData(it as ArrayList<Member>)
            }
        })
    }

}
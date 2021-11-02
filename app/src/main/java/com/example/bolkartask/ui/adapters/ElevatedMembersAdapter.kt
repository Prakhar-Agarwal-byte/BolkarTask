package com.example.bolkartask.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.bolkartask.databinding.ElevatedMemberViewHolderBinding
import com.example.bolkartask.models.Member

class ElevatedMembersAdapter :
    RecyclerView.Adapter<ElevatedMembersAdapter.ElevatedMemberViewHolder>() {

    private var data = ArrayList<Member>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElevatedMemberViewHolder {
        val binding = ElevatedMemberViewHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ElevatedMemberViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ElevatedMemberViewHolder, position: Int) {
        holder.binding.member = data[position]
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int = data.size

    fun setData(newData: ArrayList<Member>) {
        val diffUtil = MemberDiffUtil(data, newData)
        val result = DiffUtil.calculateDiff(diffUtil)
        this.data = newData
        result.dispatchUpdatesTo(this)
    }


    class ElevatedMemberViewHolder(val binding: ElevatedMemberViewHolderBinding) : RecyclerView.ViewHolder(binding.root)
}
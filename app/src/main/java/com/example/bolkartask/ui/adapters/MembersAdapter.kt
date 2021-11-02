package com.example.bolkartask.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.bolkartask.databinding.MemberViewHolderBinding
import com.example.bolkartask.models.Member

class MembersAdapter :
    RecyclerView.Adapter<MembersAdapter.MemberViewHolder>() {

    private var data = ArrayList<Member>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberViewHolder {
        val binding = MemberViewHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MemberViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MemberViewHolder, position: Int) {
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

    class MemberViewHolder(val binding: MemberViewHolderBinding) : RecyclerView.ViewHolder(binding.root)
}
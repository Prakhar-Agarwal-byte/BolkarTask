package com.example.bolkartask.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.bolkartask.databinding.ElevatedMemberViewHolderBinding
import com.example.bolkartask.databinding.MemberViewHolderBinding
import com.example.bolkartask.models.Member

class MembersAdapter(private val TAG: String) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var data = ArrayList<Member>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (TAG == "elevatedMembers") {
            val binding = ElevatedMemberViewHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ElevatedMemberViewHolder(binding)
        }
        val binding = MemberViewHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MemberViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (TAG == "elevatedMembers") {
            val elevatedHolder = holder as ElevatedMemberViewHolder
            elevatedHolder.binding.member = data[position]
            elevatedHolder.binding.executePendingBindings()
        } else {
            val memberHolder = holder as MemberViewHolder
            memberHolder.binding.member = data[position]
            memberHolder.binding.executePendingBindings()
        }
    }

    override fun getItemCount(): Int = data.size

    fun setData(newData: ArrayList<Member>) {
        val diffUtil = MemberDiffUtil(data, newData)
        val result = DiffUtil.calculateDiff(diffUtil)
        this.data = newData
        result.dispatchUpdatesTo(this)
    }

    class ElevatedMemberViewHolder(val binding: ElevatedMemberViewHolderBinding) : RecyclerView.ViewHolder(binding.root)
    class MemberViewHolder(val binding: MemberViewHolderBinding) : RecyclerView.ViewHolder(binding.root)
}
package com.example.bolkartask.ui.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.bolkartask.models.Member

class MemberDiffUtil(
    private val oldList: List<Member>,
    private val newList: List<Member>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean = oldList[oldItemPosition]._id == newList[newItemPosition]._id


    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean = oldList[oldItemPosition] == newList[newItemPosition]
}
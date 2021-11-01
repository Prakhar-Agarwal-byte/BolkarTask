package com.example.bolkartask.ui.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.bolkartask.models.Member


@BindingAdapter("loadMemberImg")
fun ImageView.loadMemberImg(member: Member?) {
    member?.let {
        val url = "https://cdn1.bolkarapp.com/uploads/dp/${member.u}.jpg"
        Glide.with(this.context).load(url).into(this);
    }
}

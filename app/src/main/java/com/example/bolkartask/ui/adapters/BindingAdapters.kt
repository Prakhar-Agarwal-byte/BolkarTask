package com.example.bolkartask.ui.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.bolkartask.R
import com.example.bolkartask.models.Member
import com.google.android.material.card.MaterialCardView


@BindingAdapter("loadMemberImg")
fun ImageView.loadMemberImg(member: Member?) {
    member?.let {
        val url = "https://cdn1.bolkarapp.com/uploads/dp/${member.u}.jpg"
        Glide.with(this.context).load(url).into(this)
    }
}

@BindingAdapter("shouldShowBorder")
fun MaterialCardView.shouldShowBorder(member: Member) {
    if (member.role == "host") {
        apply {
            strokeColor = resources.getColor(R.color.cyan)
            strokeWidth = resources.getDimension(R.dimen.stroke_width).toInt()
        }
    }
}

@BindingAdapter("shouldBeVisible")
fun MaterialCardView.shouldBeVisible(member: Member) {
    if (member.mic) {
        this.visibility = View.GONE
    }
}

@BindingAdapter("showMemberName")
fun TextView.showMemberName(member: Member) {
    this.text = member.n
    if (member.role == "host" || member.mod) {
        this.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_host_badge, 0, 0 ,0)
    }
}

@BindingAdapter("showRole")
fun TextView.showRole(member: Member) {
    when(member.role) {
        "host" -> this.text = resources.getString(R.string.host)
        "speaker" -> this.text = resources.getString(R.string.speaker)
    }
    if (member.mod) {
        this.text = resources.getString(R.string.host)
    }
}

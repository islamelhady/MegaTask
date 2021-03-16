package com.elhady.mega.ui.base.bindings

import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.elhady.mega.R


@BindingAdapter("jobSrc")
fun ImageView.bindJobsSrc(imagePath: String) {
    Glide.with(this.context)
        .load(imagePath)
        .error(ContextCompat.getDrawable(this.context, R.drawable.ic_not_found))
        .into(this)
}

package com.elhady.mega.ui.binding

import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.elhady.mega.R

/**
 * Created by islam elhady on 03/16/2021.
 */
@BindingAdapter("jobSrc")
fun bindJobSrc(view: ImageView, companyLogo: String?) {
    if (!companyLogo.isNullOrEmpty()) {
        Glide.with(view.context)
            .load(companyLogo)
            .error(ContextCompat.getDrawable(view.context, R.drawable.not_found))
            .into(view)
    }
}
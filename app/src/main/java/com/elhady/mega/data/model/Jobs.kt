package com.elhady.mega.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Jobs(
    val id: String,
    val company: String,
    val location: String,
    val title: String,
    val type: String,
    val url: String,
    val description: String
) : Parcelable
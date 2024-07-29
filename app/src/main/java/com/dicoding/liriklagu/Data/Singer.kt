package com.dicoding.liriklagu.Data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Singer(
    val name: String,
    val description: String,
    val photo: Int
): Parcelable

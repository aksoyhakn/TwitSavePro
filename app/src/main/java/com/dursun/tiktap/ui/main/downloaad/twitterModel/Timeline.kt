package com.dursun.tiktap.ui.main.downloaad.twitterModel

import com.google.gson.annotations.SerializedName

import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Timeline(
    @SerializedName("id") var id: String? = null,
    @SerializedName("instructions") var instructions: ArrayList<Instructions> = arrayListOf()
) : Parcelable
package com.dursun.tiktap.ui.main.downloaad.twitterModel

import com.google.gson.annotations.SerializedName

import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Entries(
    @SerializedName("entryId") var entryId: String? = null,
    @SerializedName("sortIndex") var sortIndex: String? = null
) : Parcelable
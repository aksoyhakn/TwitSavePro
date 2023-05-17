package com.dursun.tiktap.ui.main.downloaad.twitterModel

import com.google.gson.annotations.SerializedName


import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Content(
    @SerializedName("item") var item: Item? = Item()
) : Parcelable
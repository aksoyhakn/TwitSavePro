package com.dursun.tiktap.ui.main.downloaad.tiktokModel

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Extra(
    @SerializedName("fatal_item_ids") var fatalItemIds: ArrayList<String> = arrayListOf(),
    @SerializedName("logid") var logid: String? = null,
    @SerializedName("now") var now: Long? = null
) : Parcelable
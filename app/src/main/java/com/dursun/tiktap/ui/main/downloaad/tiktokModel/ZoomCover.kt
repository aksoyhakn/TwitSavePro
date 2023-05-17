package com.dursun.tiktap.ui.main.downloaad.tiktokModel

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ZoomCover(

    @SerializedName("240") var iki: String? = null,
    @SerializedName("480") var on: String? = null,
    @SerializedName("720") var sekiz: String? = null,
    @SerializedName("960") var dokuz: String? = null

) : Parcelable
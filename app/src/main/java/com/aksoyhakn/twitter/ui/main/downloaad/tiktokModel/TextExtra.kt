package com.aksoyhakn.twitter.ui.main.downloaad.tiktokModel

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class TextExtra(

    @SerializedName("awemeId") var awemeId: String? = null,
    @SerializedName("end") var end: Int? = null,
    @SerializedName("hashtagId") var hashtagId: String? = null,
    @SerializedName("hashtagName") var hashtagName: String? = null,
    @SerializedName("isCommerce") var isCommerce: Boolean? = null,
    @SerializedName("start") var start: Int? = null,
    @SerializedName("subType") var subType: Int? = null,
    @SerializedName("type") var type: Int? = null

) : Parcelable
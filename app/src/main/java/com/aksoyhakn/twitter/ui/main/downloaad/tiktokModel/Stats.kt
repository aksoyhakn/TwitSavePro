package com.aksoyhakn.twitter.ui.main.downloaad.tiktokModel

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Stats(

    @SerializedName("commentCount") var commentCount: Int? = null,
    @SerializedName("diggCount") var diggCount: Long? = null,
    @SerializedName("playCount") var playCount: Long? = null,
    @SerializedName("shareCount") var shareCount: Long? = null

) : Parcelable
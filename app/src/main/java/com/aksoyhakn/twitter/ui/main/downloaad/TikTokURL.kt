package com.aksoyhakn.twitter.ui.main.downloaad

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class TikTokURL(
    @SerializedName("url") var url: String? = null
) : Parcelable
package com.aksoyhakn.twitter.ui.main.downloaad.tiktokModel

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Music(

    @SerializedName("authorName") var authorName: String? = null,
    @SerializedName("coverLarge") var coverLarge: String? = null,
    @SerializedName("coverMedium") var coverMedium: String? = null,
    @SerializedName("coverThumb") var coverThumb: String? = null,
    @SerializedName("duration") var duration: Int? = null,
    @SerializedName("id") var id: String? = null,
    @SerializedName("original") var original: Boolean? = null,
    @SerializedName("playUrl") var playUrl: String? = null,
    @SerializedName("title") var title: String? = null

) : Parcelable
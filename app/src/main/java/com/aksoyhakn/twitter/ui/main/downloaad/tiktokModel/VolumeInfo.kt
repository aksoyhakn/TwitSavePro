package com.aksoyhakn.twitter.ui.main.downloaad.tiktokModel

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class VolumeInfo(

    @SerializedName("Loudness") var Loudness: Double? = null,
    @SerializedName("Peak") var Peak: Long? = 0L

) : Parcelable
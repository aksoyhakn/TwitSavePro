package com.aksoyhakn.twitter.ui.main.downloaad.tiktokModel

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class BitrateInfo(

    @SerializedName("Bitrate") var Bitrate: Int? = null,
    @SerializedName("CodecType") var CodecType: String? = null,
    @SerializedName("GearName") var GearName: String? = null,
    @SerializedName("PlayAddr") var PlayAddr: PlayAddr? = PlayAddr(),
    @SerializedName("QualityType") var QualityType: Int? = null

) : Parcelable
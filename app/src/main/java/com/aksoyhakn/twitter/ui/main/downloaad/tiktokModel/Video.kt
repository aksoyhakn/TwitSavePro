package com.aksoyhakn.twitter.ui.main.downloaad.tiktokModel

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Video(

    @SerializedName("bitrate") var bitrate: Int? = null,
    @SerializedName("bitrateInfo") var bitrateInfo: ArrayList<BitrateInfo> = arrayListOf(),
    @SerializedName("codecType") var codecType: String? = null,
    @SerializedName("cover") var cover: String? = null,
    @SerializedName("definition") var definition: String? = null,
    @SerializedName("downloadAddr") var downloadAddr: String? = null,
    @SerializedName("duration") var duration: Int? = null,
    @SerializedName("dynamicCover") var dynamicCover: String? = null,
    @SerializedName("encodeUserTag") var encodeUserTag: String? = null,
    @SerializedName("encodedType") var encodedType: String? = null,
    @SerializedName("format") var format: String? = null,
    @SerializedName("height") var height: Int? = null,
    @SerializedName("id") var id: String? = null,
    @SerializedName("originCover") var originCover: String? = null,
    @SerializedName("playAddr") var playAddr: String? = null,
    @SerializedName("ratio") var ratio: String? = null,
    @SerializedName("videoQuality") var videoQuality: String? = null,
    @SerializedName("width") var width: Int? = null,
    @SerializedName("zoomCover") var zoomCover: ZoomCover? = ZoomCover()

) : Parcelable
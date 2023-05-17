package com.dursun.tiktap.ui.main.downloaad.twitterModel

import android.os.Parcelable
import com.dursun.tiktap.ui.main.downloaad.twitterModel.GlobalObjects
import com.dursun.tiktap.ui.main.downloaad.twitterModel.Timeline
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class TwitterResponse(
    @SerializedName("globalObjects") var globalObjects: GlobalObjects?,
    @SerializedName("timeline") var timeline: Timeline? = Timeline()
) : Parcelable
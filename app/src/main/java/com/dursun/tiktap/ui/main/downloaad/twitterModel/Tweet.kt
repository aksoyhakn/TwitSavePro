package com.dursun.tiktap.ui.main.downloaad.twitterModel

import com.google.gson.annotations.SerializedName

import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Tweet(

    @SerializedName("id") var id: String? = null,
    @SerializedName("displayType") var displayType: String? = null,
    @SerializedName("hasModeratedReplies") var hasModeratedReplies: Boolean? = null

) : Parcelable
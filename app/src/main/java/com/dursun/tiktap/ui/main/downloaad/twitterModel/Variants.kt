package com.dursun.tiktap.ui.main.downloaad.twitterModel

import com.google.gson.annotations.SerializedName

import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Variants(

  @SerializedName("bitrate") var bitrate: Int? = null,
  @SerializedName("content_type") var contentType: String? = null,
  @SerializedName("url") var url: String? = null

) : Parcelable
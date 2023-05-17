package com.dursun.tiktap.ui.main.downloaad.twitterModel

import com.google.gson.annotations.SerializedName

import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class VideoInfo (

  @SerializedName("aspect_ratio"    ) var aspectRatio    : ArrayList<Int>      = arrayListOf(),
  @SerializedName("duration_millis" ) var durationMillis : Int?                = null,
  @SerializedName("variants"        ) var variants       : ArrayList<Variants> = arrayListOf()

) : Parcelable
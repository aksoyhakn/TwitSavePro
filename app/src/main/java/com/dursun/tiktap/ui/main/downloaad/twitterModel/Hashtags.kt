package com.dursun.tiktap.ui.main.downloaad.twitterModel

import com.google.gson.annotations.SerializedName

import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Hashtags (

  @SerializedName("text"    ) var text    : String?        = null,
  @SerializedName("indices" ) var indices : ArrayList<Int> = arrayListOf()

) : Parcelable
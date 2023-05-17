package com.dursun.tiktap.ui.main.downloaad.twitterModel

import com.google.gson.annotations.SerializedName

import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Urls (

  @SerializedName("url"          ) var url         : String?        = null,
  @SerializedName("expanded_url" ) var expandedUrl : String?        = null,
  @SerializedName("display_url"  ) var displayUrl  : String?        = null,
  @SerializedName("indices"      ) var indices     : ArrayList<Int> = arrayListOf()

) : Parcelable
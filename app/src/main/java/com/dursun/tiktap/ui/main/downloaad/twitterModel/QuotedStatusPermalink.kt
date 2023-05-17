package com.dursun.tiktap.ui.main.downloaad.twitterModel

import com.google.gson.annotations.SerializedName

import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class QuotedStatusPermalink (

  @SerializedName("url"      ) var url      : String? = null,
  @SerializedName("expanded" ) var expanded : String? = null,
  @SerializedName("display"  ) var display  : String? = null

) : Parcelable
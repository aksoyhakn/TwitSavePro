package com.dursun.tiktap.ui.main.downloaad.twitterModel

import android.os.Parcelable
import com.google.gson.annotations.SerializedName

import kotlinx.parcelize.Parcelize

@Parcelize
data class AdditionalMediaInfo (
  @SerializedName("monetizable" ) var monetizable : Boolean? = null
) : Parcelable
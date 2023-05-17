package com.dursun.tiktap.ui.main.downloaad.twitterModel

import com.google.gson.annotations.SerializedName

import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class UserMentions (

  @SerializedName("screen_name" ) var screenName : String?        = null,
  @SerializedName("name"        ) var name       : String?        = null,
  @SerializedName("id_str"      ) var idStr      : String?        = null,
  @SerializedName("indices"     ) var indices    : ArrayList<Int> = arrayListOf()

) : Parcelable
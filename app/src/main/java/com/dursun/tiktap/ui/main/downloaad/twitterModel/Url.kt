package com.dursun.tiktap.ui.main.downloaad.twitterModel

import com.google.gson.annotations.SerializedName

import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Url (

  @SerializedName("urls" ) var urls : ArrayList<Urls> = arrayListOf()

) :Parcelable
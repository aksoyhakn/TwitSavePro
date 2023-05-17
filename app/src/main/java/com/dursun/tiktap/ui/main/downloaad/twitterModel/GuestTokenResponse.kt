package com.dursun.tiktap.ui.main.downloaad.twitterModel

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class GuestTokenResponse(
    @SerializedName("guest_token") var token: String? = null
) : Parcelable
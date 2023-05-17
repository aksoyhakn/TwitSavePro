package com.dursun.tiktap.ui.main.downloaad.tiktokModel

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class LogPb(
    @SerializedName("impr_id") var imprId: String? = null
) : Parcelable
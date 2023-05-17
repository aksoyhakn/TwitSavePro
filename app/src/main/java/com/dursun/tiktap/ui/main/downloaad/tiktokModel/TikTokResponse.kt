package com.dursun.tiktap.ui.main.downloaad.tiktokModel

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class TikTokResponse(
    @SerializedName("extra") var extra: Extra? = null,
    @SerializedName("itemInfo") var itemInfo: ItemInfo? = null,
    @SerializedName("log_pb") var logPb: LogPb? = null,
    @SerializedName("shareMeta") var shareMeta: ShareMeta? = null,
    @SerializedName("statusCode") val statusCode: Long? = null,
    @SerializedName("status_code") val statusCodeiki: Long? = null
) : Parcelable
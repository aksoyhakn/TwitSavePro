package com.dursun.tiktap.ui.main.downloaad.twitterModel

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Media(

    @SerializedName("id_str") var idStr: String? = null,
    @SerializedName("indices") var indices: ArrayList<Int> = arrayListOf(),
    @SerializedName("media_url") var mediaUrl: String? = null,
    @SerializedName("media_url_https") var mediaUrlHttps: String? = null,
    @SerializedName("url") var url: String? = null,
    @SerializedName("display_url") var displayUrl: String? = null,
    @SerializedName("expanded_url") var expandedUrl: String? = null,
    @SerializedName("type") var type: String? = null

) : Parcelable
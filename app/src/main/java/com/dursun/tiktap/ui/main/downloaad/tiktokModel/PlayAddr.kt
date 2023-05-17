package com.dursun.tiktap.ui.main.downloaad.tiktokModel

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PlayAddr(

    @SerializedName("DataSize") var DataSize: Int? = null,
    @SerializedName("FileCs") var FileCs: String? = null,
    @SerializedName("FileHash") var FileHash: String? = null,
    @SerializedName("Uri") var Uri: String? = null,
    @SerializedName("UrlKey") var UrlKey: String? = null,
    @SerializedName("UrlList") var UrlList: ArrayList<String> = arrayListOf()

) : Parcelable
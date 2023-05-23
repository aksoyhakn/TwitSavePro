package com.aksoyhakn.twitter.ui.main.downloaad.tiktokModel

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ShareMeta(
    @SerializedName("desc") var desc: String? = null,
    @SerializedName("title") var title: String? = null
) : Parcelable
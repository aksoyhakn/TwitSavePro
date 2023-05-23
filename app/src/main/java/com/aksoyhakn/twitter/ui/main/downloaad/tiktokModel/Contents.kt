package com.aksoyhakn.twitter.ui.main.downloaad.tiktokModel

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Contents(

    @SerializedName("desc") var desc: String? = null,
    @SerializedName("textExtra") var textExtra: ArrayList<TextExtra> = arrayListOf()

) : Parcelable
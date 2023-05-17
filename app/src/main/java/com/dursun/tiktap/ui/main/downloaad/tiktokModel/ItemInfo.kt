package com.dursun.tiktap.ui.main.downloaad.tiktokModel

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItemInfo(

    @SerializedName("itemStruct") var itemStruct: ItemStruct? = ItemStruct()

) : Parcelable
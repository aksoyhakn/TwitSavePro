package com.aksoyhakn.twitter.ui.main.premium.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Premium(
    @SerializedName("id") var id: String? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("amount") var amount: String? = null,
    @SerializedName("description") var description: String? = null,
) : Parcelable
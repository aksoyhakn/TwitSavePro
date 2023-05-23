package com.aksoyhakn.twitter.data.service.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by hakanaksoy on 17.12.22.
 * NargileyeFısıldayanAdam
 */

@Parcelize
data class FriendlyMessage(
    @SerializedName("title") val title: String?,
    @SerializedName("message") val message: String?,
    @SerializedName("cancelable") var cancelable: Boolean? = true,
    @SerializedName("buttonNegative") var buttonNegative: String?,
    @SerializedName("buttonPositive") var buttonPositive: String?,
    @SerializedName("buttonNeutral") var buttonNeutral: String?
) : Parcelable

@Parcelize
data class ErrorMessage(
    @SerializedName("Title") val title: String?,
    @SerializedName("Message") val message: String?,
    @SerializedName("Cancelable") var cancelable: Boolean? = true
) : Parcelable

@Parcelize
data class ErrorMessageResponse(
    @SerializedName("error") val error: String?,
    @SerializedName("error_description") val error_description: String?,
    @SerializedName("friendlyMessage") var friendlyMessage: ErrorMessage?
) : Parcelable
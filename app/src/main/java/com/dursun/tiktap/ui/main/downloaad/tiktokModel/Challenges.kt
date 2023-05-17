package com.dursun.tiktap.ui.main.downloaad.tiktokModel

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Challenges(

    @SerializedName("coverLarger") var coverLarger: String? = null,
    @SerializedName("coverMedium") var coverMedium: String? = null,
    @SerializedName("coverThumb") var coverThumb: String? = null,
    @SerializedName("desc") var desc: String? = null,
    @SerializedName("id") var id: String? = null,
    @SerializedName("profileLarger") var profileLarger: String? = null,
    @SerializedName("profileMedium") var profileMedium: String? = null,
    @SerializedName("profileThumb") var profileThumb: String? = null,
    @SerializedName("title") var title: String? = null

) : Parcelable
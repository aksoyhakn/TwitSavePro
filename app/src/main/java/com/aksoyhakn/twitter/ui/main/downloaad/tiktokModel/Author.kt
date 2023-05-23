package com.aksoyhakn.twitter.ui.main.downloaad.tiktokModel

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Author(
    @SerializedName("avatarLarger") var avatarLarger: String? = null,
    @SerializedName("avatarMedium") var avatarMedium: String? = null,
    @SerializedName("avatarThumb") var avatarThumb: String? = null,
    @SerializedName("commentSetting") var commentSetting: Int? = null,
    @SerializedName("downloadSetting") var downloadSetting: Int? = null,
    @SerializedName("duetSetting") var duetSetting: Int? = null,
    @SerializedName("ftc") var ftc: Boolean? = null,
    @SerializedName("id") var id: String? = null,
    @SerializedName("isADVirtual") var isADVirtual: Boolean? = null,
    @SerializedName("nickname") var nickname: String? = null,
    @SerializedName("openFavorite") var openFavorite: Boolean? = null,
    @SerializedName("privateAccount") var privateAccount: Boolean? = null,
    @SerializedName("relation") var relation: Int? = null,
    @SerializedName("roomId") var roomId: String? = null,
    @SerializedName("secUid") var secUid: String? = null,
    @SerializedName("secret") var secret: Boolean? = null,
    @SerializedName("signature") var signature: String? = null,
    @SerializedName("stitchSetting") var stitchSetting: Int? = null,
    @SerializedName("uniqueId") var uniqueId: String? = null,
    @SerializedName("verified") var verified: Boolean? = null
) : Parcelable
package com.aksoyhakn.twitter.ui.main.downloaad.tiktokModel

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItemStruct(

    @SerializedName("author") var author: Author? = Author(),
    @SerializedName("challenges") var challenges: ArrayList<Challenges> = arrayListOf(),
    @SerializedName("contents") var contents: ArrayList<Contents> = arrayListOf(),
    @SerializedName("createTime") var createTime: Long? = null,
    @SerializedName("desc") var desc: String? = null,
    @SerializedName("digged") var digged: Boolean? = null,
    @SerializedName("duetDisplay") var duetDisplay: Int? = null,
    @SerializedName("duetEnabled") var duetEnabled: Boolean? = null,
    @SerializedName("forFriend") var forFriend: Boolean? = null,
    @SerializedName("id") var id: String? = null,
    @SerializedName("itemCommentStatus") var itemCommentStatus: Int? = null,
    @SerializedName("music") var music: Music? = Music(),
    @SerializedName("officalItem") var officalItem: Boolean? = null,
    @SerializedName("originalItem") var originalItem: Boolean? = null,
    @SerializedName("privateItem") var privateItem: Boolean? = null,
    @SerializedName("secret") var secret: Boolean? = null,
    @SerializedName("shareEnabled") var shareEnabled: Boolean? = null,
    @SerializedName("stats") var stats: Stats? = Stats(),
    @SerializedName("stitchDisplay") var stitchDisplay: Int? = null,
    @SerializedName("stitchEnabled") var stitchEnabled: Boolean? = null,
    @SerializedName("suggestedWords") var suggestedWords: ArrayList<String> = arrayListOf(),
    @SerializedName("textExtra") var textExtra: ArrayList<TextExtra> = arrayListOf(),
    @SerializedName("video") var video: Video? = Video()

) : Parcelable
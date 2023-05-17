package com.dursun.tiktap.ui.main.downloaad.twitterModel

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Tweets(

    @SerializedName("created_at") var createdAt: String? = null,
    @SerializedName("id_str") var idStr: String? = null,
    @SerializedName("full_text") var fullText: String? = null,
    @SerializedName("display_text_range") var displayTextRange: ArrayList<Int> = arrayListOf(),
    @SerializedName("extended_entities") var extendedEntities: ExtendedEntities? = ExtendedEntities(),
    @SerializedName("source") var source: String? = null,
    @SerializedName("user_id_str") var userIdStr: String? = null,
    @SerializedName("retweet_count") var retweetCount: Int? = null,
    @SerializedName("favorite_count") var favoriteCount: Int? = null,
    @SerializedName("conversation_id_str") var conversationIdStr: String? = null,
    @SerializedName("possibly_sensitive_editable") var possiblySensitiveEditable: Boolean? = null,
    @SerializedName("lang") var lang: String? = null

) : Parcelable
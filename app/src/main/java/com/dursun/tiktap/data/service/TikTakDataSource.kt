package com.dursun.tiktap.data.service

import com.dursun.tiktap.ui.main.downloaad.tiktokModel.TikTokResponse
import com.dursun.tiktap.ui.main.downloaad.twitterModel.GuestTokenResponse
import com.dursun.tiktap.ui.main.downloaad.twitterModel.TwitterResponse
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by hakanaksoy on 17.12.22.
 * NargileyeFısıldayanAdam
 */

class TikTakDataSource @Inject constructor(
    private val tikTakService: TikTakService
) {

    suspend fun downloadTikTok(itemId: String): Response<TikTokResponse> =
        tikTakService.downloadTikTok(itemId)

    suspend fun getTikTokURL(url: String): Response<TwitterResponse> =
        tikTakService.getTikTokURL(url)

    suspend fun twitter(): Response<GuestTokenResponse> =
        tikTakService.twitter("https://api.twitter.com/1.1/guest/activate.json")

    suspend fun twitterDownload(itemId:String): Response<TwitterResponse> =
        tikTakService.twitterDownload("https://twitter.com/i/api/2/timeline/conversation/${itemId}.json?include_entities=true&tweet_mode=extended&count=1")


}
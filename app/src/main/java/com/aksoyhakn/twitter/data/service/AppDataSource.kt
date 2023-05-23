package com.aksoyhakn.twitter.data.service

import com.aksoyhakn.twitter.ui.main.downloaad.tiktokModel.TikTokResponse
import com.aksoyhakn.twitter.ui.main.downloaad.TikTokURL
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by hakanaksoy on 17.12.22.
 * NargileyeFısıldayanAdam
 */

class AppDataSource @Inject constructor(
    private val appService: AppService
) {

    suspend fun downloadTikTok(itemId: String): Response<TikTokResponse> =
        appService.downloadTikTok(itemId)

    suspend fun getTikTokURL(url: String): Response<TikTokURL> =
        appService.getTikTokURL(url)

}
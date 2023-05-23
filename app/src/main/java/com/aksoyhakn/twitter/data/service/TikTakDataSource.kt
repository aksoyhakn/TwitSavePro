package com.aksoyhakn.twitter.data.service

import com.aksoyhakn.twitter.ui.main.downloaad.tiktokModel.TikTokResponse
import com.aksoyhakn.twitter.ui.main.downloaad.TikTokURL
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

    suspend fun getTikTokURL(url: String): Response<TikTokURL> =
        tikTakService.getTikTokURL(url)

}
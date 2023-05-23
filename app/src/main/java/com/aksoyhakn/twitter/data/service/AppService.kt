package com.aksoyhakn.twitter.data.service

import com.aksoyhakn.twitter.ui.main.downloaad.tiktokModel.TikTokResponse
import com.aksoyhakn.twitter.ui.main.downloaad.TikTokURL
import retrofit2.Response
import retrofit2.http.*

/**
 * Created by hakanaksoy on 17.12.22.
 * NargileyeFısıldayanAdam
 */

interface AppService {
    @Headers(
        "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36"
    )
    @GET("detail/")
    suspend fun downloadTikTok(
        @Query("itemId") id: String?,
    ): Response<TikTokResponse>

    @Headers(
        "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.121 Safari/537.36",
        "Origin: https://www.tiktok.com",
        "Referer: https://www.tiktok.com/",
        "Sec-Fetch-Dest: empty",
        "Sec-Fetch-Mode: cors",
        "Sec-Fetch-Site: cross-site",
        "Cache-Control: no-cache",
        "Host: v16-webapp-prime.tiktok.com"
    )
    @GET
    suspend fun getTikTokURL(
        @Url url: String?
    ): Response<TikTokURL>

}
package com.aksoyhakn.twitter.ui.main.downloaad


import com.aksoyhakn.twitter.data.service.AppDataSource
import com.aksoyhakn.twitter.data.service.util.NetworkBoundRepository
import com.aksoyhakn.twitter.data.service.util.State
import com.aksoyhakn.twitter.ui.main.downloaad.tiktokModel.TikTokResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject


class DownloadRepository @Inject constructor(
    private val appDataSource: AppDataSource
) {

    fun downloadTikTok(itemId: String): Flow<State<TikTokResponse>> {
        return object : NetworkBoundRepository<TikTokResponse, TikTokResponse>() {
            override suspend fun fetchFromRemote(): Response<TikTokResponse> =
                appDataSource.downloadTikTok(itemId)
        }.asFlow()
    }

    fun getTikTokURL(url: String): Flow<State<TikTokURL>> {
        return object : NetworkBoundRepository<TikTokURL, TikTokURL>() {
            override suspend fun fetchFromRemote(): Response<TikTokURL> =
                appDataSource.getTikTokURL(url)
        }.asFlow()
    }

}
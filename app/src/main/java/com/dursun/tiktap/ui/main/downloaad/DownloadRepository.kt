package com.dursun.tiktap.ui.main.downloaad


import com.dursun.tiktap.data.service.TikTakDataSource
import com.dursun.tiktap.data.service.util.NetworkBoundRepository
import com.dursun.tiktap.data.service.util.State
import com.dursun.tiktap.ui.main.downloaad.tiktokModel.TikTokResponse
import com.dursun.tiktap.ui.main.downloaad.twitterModel.GuestTokenResponse
import com.dursun.tiktap.ui.main.downloaad.twitterModel.TwitterResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject


class DownloadRepository @Inject constructor(
    private val tikTakDataSource: TikTakDataSource
) {

    fun downloadTikTok(itemId: String): Flow<State<TikTokResponse>> {
        return object : NetworkBoundRepository<TikTokResponse, TikTokResponse>() {
            override suspend fun fetchFromRemote(): Response<TikTokResponse> =
                tikTakDataSource.downloadTikTok(itemId)
        }.asFlow()
    }

    fun getTikTokURL(url: String): Flow<State<TwitterResponse>> {
        return object : NetworkBoundRepository<TwitterResponse, TwitterResponse>() {
            override suspend fun fetchFromRemote(): Response<TwitterResponse> =
                tikTakDataSource.getTikTokURL(url)
        }.asFlow()
    }

    fun twitter(): Flow<State<GuestTokenResponse>> {
        return object : NetworkBoundRepository<GuestTokenResponse, GuestTokenResponse>() {
            override suspend fun fetchFromRemote(): Response<GuestTokenResponse> =
                tikTakDataSource.twitter()
        }.asFlow()
    }

    fun twitterDownload(itemId: String): Flow<State<TwitterResponse>> {
        return object : NetworkBoundRepository<TwitterResponse, TwitterResponse>() {
            override suspend fun fetchFromRemote(): Response<TwitterResponse> =
                tikTakDataSource.twitterDownload(itemId)
        }.asFlow()
    }

}
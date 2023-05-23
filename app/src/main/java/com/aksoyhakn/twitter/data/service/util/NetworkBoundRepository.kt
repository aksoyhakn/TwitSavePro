package com.aksoyhakn.twitter.data.service.util

import androidx.annotation.MainThread
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.Response

/**
 * Created by hakanaksoy on 17.12.22.
 * NargileyeFısıldayanAdam
 */

abstract class NetworkBoundRepository<RESULT, REQUEST> {

    fun asFlow() = flow<State<RESULT>> {

        emit(State.loading(true))

        val apiResponse = fetchFromRemote()
        val remotePosts = apiResponse.body()

        if (apiResponse.isSuccessful && remotePosts != null) {
            emit(State.success(apiResponse))
        }
    }.catch { e ->
        emit(State.error(e))
    }

    @MainThread
    protected abstract suspend fun fetchFromRemote(): Response<RESULT>
}
package com.aksoyhakn.twitter.data.service.util

import retrofit2.Response

/**
 * Created by hakanaksoy on 17.12.22.
 * NargileyeFısıldayanAdam
 */

sealed class State<T> {
    class Loading<T>(val isLoading: Boolean) : State<T>()

    data class Success<T>(val data: Response<T>) : State<T>()

    data class Error<T>(val throwable: Throwable) : State<T>()

    data class IdentityError<T>(val baseResponse: String) : State<T>()

    companion object {

        fun <T> loading(isLoading: Boolean) = Loading<T>(isLoading)

        fun <T> success(data: Response<T>) =
            Success(data)

        fun <T> error(throwable: Throwable) =
            Error<T>(throwable)

    }
}

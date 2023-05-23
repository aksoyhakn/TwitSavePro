package com.aksoyhakn.twitter.data.service

import android.os.Build
import androidx.annotation.RequiresApi
import com.aksoyhakn.twitter.data.preference.PreferenceHelperImp
import com.orhanobut.logger.Logger
import okhttp3.Interceptor
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import java.io.IOException
import java.net.ProtocolException
import java.util.Base64
import javax.inject.Inject

/**
 * Created by hakanaksoy on 17.12.22.
 * NargileyeFısıldayanAdam
 */

class LoggingInterceptor @Inject constructor(var preferenceHelperImp: PreferenceHelperImp) :
    Interceptor {

    @RequiresApi(Build.VERSION_CODES.O)
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val requestBuilder = request.newBuilder().method(request.method, request.body)
        val newRequest = requestBuilder.build()

        val response: Response = try {
            chain.proceed(newRequest)
        } catch (e: ProtocolException) {
            Response.Builder()
                .request(request)
                .code(200)
                .protocol(Protocol.HTTP_1_1)
                .build()
        }

        var rawJson: String? = null

        try {
            rawJson = response.body?.string()
            Logger.json(rawJson)

        } catch (e: Exception) {
            rawJson = response.body?.string()
            Logger.e("Null response body")
        }

        return response.newBuilder()
            .body(rawJson.toString().toResponseBody(request.body?.contentType())).build()
    }
}
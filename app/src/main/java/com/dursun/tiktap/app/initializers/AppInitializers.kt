package com.dursun.tiktap.app.initializers

import android.app.Application
import com.dursun.tiktap.app.initializers.AppInitializer
import javax.inject.Inject


/**
 * Created by hakanaksoy on 17.12.22.
 * NargileyeFısıldayanAdam
 */


class AppInitializers @Inject constructor(
    private val initializers: Set<@JvmSuppressWildcards AppInitializer>
) {
    fun init(application: Application) {
        initializers.forEach {
            it.init(application)
        }
    }
}
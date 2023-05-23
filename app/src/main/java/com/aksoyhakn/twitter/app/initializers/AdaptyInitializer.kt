package com.aksoyhakn.twitter.app.initializers

import android.app.Application
import com.adapty.Adapty
import javax.inject.Inject


class AdaptyInitializer @Inject constructor() : AppInitializer {
    override fun init(application: Application) {
        Adapty.activate(
            application.applicationContext,
            "PUBLIC_SDK_KEY",
            observerMode = false,
            customerUserId = "YOUR_USER_ID"
        )
    }
}
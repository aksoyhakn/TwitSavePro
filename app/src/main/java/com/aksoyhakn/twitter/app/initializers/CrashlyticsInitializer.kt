package com.aksoyhakn.twitter.app.initializers

import android.app.Application
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.crashlytics.FirebaseCrashlytics
import javax.inject.Inject

/**
 * Created by hakanaksoy on 17.12.22.
 * NargileyeFısıldayanAdam
 */

class CrashlyticsInitializer @Inject constructor() : AppInitializer {
    override fun init(application: Application) {
        FirebaseAnalytics.getInstance(application)
        FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(true)
    }
}
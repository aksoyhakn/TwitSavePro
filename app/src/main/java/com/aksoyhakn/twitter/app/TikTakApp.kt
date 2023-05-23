package com.aksoyhakn.twitter.app

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.aksoyhakn.twitter.app.initializers.AppInitializers
import com.aksoyhakn.twitter.di.DaggerAppInitializerComponent
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

/**
 * Created by hakanaksoy on 17.12.22.
 * NargileyeFısıldayanAdam
 */

@ExperimentalCoroutinesApi
@HiltAndroidApp
class TikTakApp : Application() {

    @Inject
    lateinit var initializers: AppInitializers

    override fun onCreate() {
        super.onCreate()
        DaggerAppInitializerComponent.builder().build()
        initializers.init(this)
        instance = this
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }


    companion object {
        lateinit var instance: TikTakApp
    }
}

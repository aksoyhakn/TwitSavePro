package com.aksoyhakn.twitter.extensions

import android.content.Context
import android.content.res.Configuration
import android.os.Build
import com.aksoyhakn.twitter.BuildConfig

val Context.versionOS: String
    get() {
        val vOS = Build.VERSION.RELEASE
        return when {
            vOS.split('.').count() == 3 -> {
                (vOS.split('.')[0] + "." + vOS.split('.')[1] + "." + vOS.split('.')[2])
            }
            vOS.split('.').count() == 2 -> {
                "$vOS.0"
            }
            else -> {
                "$vOS.0.0"
            }
        }
    }

val Context.versionApp: String
    get() {
        val vName = BuildConfig.VERSION_NAME
        return when {
            vName.split('.').count() >= 3 -> {
                (vName.split('.')[0] + "." + vName.split('.')[1] + "." + vName.split('.')[2])
            }
            vName.split('.').count() == 2 -> {
                "$vName.0"
            }
            else -> {
                "$vName.0.0"
            }
        }
    }

val Context.OS: String
    get() = "ANDROID"

fun Context.isTablet(): Boolean {
    return ((this.resources.configuration.screenLayout and Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE)
}

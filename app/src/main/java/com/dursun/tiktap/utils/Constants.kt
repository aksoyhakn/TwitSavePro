package com.dursun.tiktap.utils

/**
 * Created by hakanaksoy on 17.12.22.
 * NargileyeFısıldayanAdam
 */


object Constants {

    object App {
        const val TIMESTAMP_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ"
        const val DB_NAME = "trend-line"
        const val PREF_NAME = "trend-line-pref"
        val REQ_USER_CONSENT = 2020

        enum class LoggedInMode constructor(val type: Int) {
            LOGGED_IN_MODE_LOGGED_OUT(0),
            LOGGED_IN_MODE_PROFILE(1),
            LOGGED_IN_MODE_SERVER(2)
        }
    }


    object Main {
        val DOWNLOAD_DATA = "download_data"
        val PREMIUM_DATA = "premium_data"

    }

}
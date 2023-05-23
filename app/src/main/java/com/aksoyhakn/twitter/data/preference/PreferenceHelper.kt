package com.aksoyhakn.twitter.data.preference

import com.aksoyhakn.twitter.utils.Constants

/**
 * Created by hakanaksoy on 17.12.22.
 * NargileyeFısıldayanAdam
 */

interface PreferenceHelper {

    fun setIsFirstApp(isFirst: Boolean?)
    fun getIsFirstApp(): Boolean?
    fun setQuestToken(token: String?)
    fun getQuestToken(): String?

}
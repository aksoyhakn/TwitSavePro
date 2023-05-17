package com.dursun.tiktap.data.preference

import com.dursun.tiktap.utils.Constants

/**
 * Created by hakanaksoy on 17.12.22.
 * NargileyeFısıldayanAdam
 */

interface PreferenceHelper {

    fun getLanguage(): String?
    fun setLanguage(languageCode: String?)

    fun getBaseURL(): String?
    fun setBaseURL(languageCode: String?)

    fun getInit(): String?
    fun setInit(init: String?)

    fun getAccessToken(): String?
    fun setAccessToken(languageCode: String?)

    fun getUserInfo(): String?
    fun setUserInfo(userInfo: String?)

    fun getUserID(): String?
    fun setUserID(userID: String?)

    fun getCurrentUserLoggedInMode(): Int
    fun setCurrentUserLoggedInMode(mode: Constants.App.LoggedInMode)

    fun setIsFirstApp(isFirst: Boolean?)
    fun getIsFirstApp(): Boolean?

    fun setQuestToken(token: String?)
    fun getQuestToken(): String?


}
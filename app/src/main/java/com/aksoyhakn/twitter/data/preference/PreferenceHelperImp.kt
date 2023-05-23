package com.aksoyhakn.twitter.data.preference

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.aksoyhakn.twitter.utils.Constants
import com.securepreferences.SecurePreferences
import javax.inject.Inject

/**
 * Created by hakanaksoy on 17.12.22.
 * NargileyeFısıldayanAdam
 */

class PreferenceHelperImp @Inject constructor(
    context: Context,
    prefFileName: String
) : PreferenceHelper {

    companion object {
        const val PREF_KEY_LANGUAGE = "PREF_KEY_LANGUAGE"
        const val PREF_KEY_BASE_URL = "PREF_KEY_BASE_URL"
        const val PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN"
        const val PREF_KEY_USER_LOGGED_IN_MODE = "PREF_KEY_USER_LOGGED_IN_MODE"
        const val PREF_KEY_OPEN_ONBOARDING = "PREF_KEY_OPEN_ONBOARDING"
        const val PREF_KEY_OPEN_INIT = "PREF_KEY_OPEN_INIT"
        const val PREF_KEY_USER_ID = "PREF_KEY_USER_ID"
        const val PREF_KEY_TOKEN_USER_INFO = "PREF_KEY_TOKEN_ISPROFILE_COMPLETED"
        const val PREF_KEY_GUEST_TOKEN = "PREF_KEY_GUEST_TOKEN"

    }

    private val mPrefs: SharedPreferences = SecurePreferences(context, "loodos", prefFileName)

    override fun getLanguage(): String? = mPrefs.getString(PREF_KEY_LANGUAGE, "")

    override fun setLanguage(languageCode: String?) {
        mPrefs.edit { putString(PREF_KEY_LANGUAGE, languageCode) }
    }

    override fun getBaseURL(): String? =
        mPrefs.getString(PREF_KEY_BASE_URL, "BuildConfig.BASE_URL")

    override fun setBaseURL(languageCode: String?) {
        mPrefs.edit { putString(PREF_KEY_BASE_URL, languageCode) }
    }

    override fun getAccessToken(): String? = mPrefs.getString(PREF_KEY_ACCESS_TOKEN, "")

    override fun setAccessToken(accessToken: String?) =
        mPrefs.edit { putString(PREF_KEY_ACCESS_TOKEN, accessToken) }

    override fun getCurrentUserLoggedInMode() = mPrefs.getInt(
        PREF_KEY_USER_LOGGED_IN_MODE,
        Constants.App.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.type
    )

    override fun setCurrentUserLoggedInMode(mode: Constants.App.LoggedInMode) {
        mPrefs.edit { putInt(PREF_KEY_USER_LOGGED_IN_MODE, mode.type) }
    }

    fun isUserLoggedIn() =
        getCurrentUserLoggedInMode() != (Constants.App.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.type)
                && getCurrentUserLoggedInMode() != (Constants.App.LoggedInMode.LOGGED_IN_MODE_PROFILE.type)

    override fun getIsFirstApp(): Boolean? = mPrefs.getBoolean(PREF_KEY_OPEN_ONBOARDING, true)

    override fun setIsFirstApp(isFirst: Boolean?) =
        mPrefs.edit { putBoolean(PREF_KEY_OPEN_ONBOARDING, isFirst ?: false) }

    override fun getInit(): String? =
        mPrefs.getString(PREF_KEY_OPEN_INIT, "")

    override fun setInit(init: String?) {
        mPrefs.edit { putString(PREF_KEY_OPEN_INIT, init) }
    }

    override fun getUserID(): String? =
        mPrefs.getString(PREF_KEY_USER_ID, "cf97cbd1-394f-48a2-bde6-dc52530e6e56")

    override fun setUserID(userID: String?) =
        mPrefs.edit { putString(PREF_KEY_USER_ID, userID) }

    override fun getUserInfo(): String? = mPrefs.getString(PREF_KEY_TOKEN_USER_INFO, "")

    override fun setUserInfo(userInfo: String?) =
        mPrefs.edit { putString(PREF_KEY_TOKEN_USER_INFO, userInfo) }

    override fun getQuestToken(): String? = mPrefs.getString(PREF_KEY_GUEST_TOKEN, null)

    override fun setQuestToken(token: String?) =
        mPrefs.edit { putString(PREF_KEY_GUEST_TOKEN, token) }

}
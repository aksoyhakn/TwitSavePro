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
        const val PREF_KEY_OPEN_ONBOARDING = "PREF_KEY_OPEN_ONBOARDING"
        const val PREF_KEY_GUEST_TOKEN = "PREF_KEY_GUEST_TOKEN"
    }

    private val mPrefs: SharedPreferences = SecurePreferences(context, "loodos", prefFileName)

    override fun getIsFirstApp(): Boolean? = mPrefs.getBoolean(PREF_KEY_OPEN_ONBOARDING, true)

    override fun setIsFirstApp(isFirst: Boolean?) =
        mPrefs.edit { putBoolean(PREF_KEY_OPEN_ONBOARDING, isFirst ?: false) }

    override fun getQuestToken(): String? = mPrefs.getString(PREF_KEY_GUEST_TOKEN, null)

    override fun setQuestToken(token: String?) =
        mPrefs.edit { putString(PREF_KEY_GUEST_TOKEN, token) }

}
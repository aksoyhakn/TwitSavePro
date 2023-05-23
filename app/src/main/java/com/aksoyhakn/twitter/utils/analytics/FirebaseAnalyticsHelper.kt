package com.aksoyhakn.twitter.utils.analytics

import android.content.Context
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import javax.inject.Inject

/**
 * Created by hakanaksoy on 17.12.22.
 * NargileyeFısıldayanAdam
 */


class FirebaseAnalyticsHelper @Inject constructor(
    context: Context
) : AnalyticsHelper {

    private var firebaseAnalytics: FirebaseAnalytics = FirebaseAnalytics.getInstance(context)

    init {
        firebaseAnalytics.setAnalyticsCollectionEnabled(true)
    }

/*    override fun setScreen(
        screenName: String,
        activity: BaseActivity<*>?
    ) {
        activity?.let {
            val params = Bundle().apply {
                putString(FirebaseAnalytics.Param.SCREEN_NAME, screenName)
                putString(FirebaseAnalytics.Param.SCREEN_CLASS, it.javaClass.simpleName)
            }
            firebaseAnalytics.run {
                logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, params)
            }
        }
    }

    override fun setScreenFragment(
        screenName: String,
        fragment: BaseFragment<*>?
    ) {
        fragment?.let {
            val params = Bundle().apply {
                putString(FirebaseAnalytics.Param.SCREEN_NAME, screenName)
                putString(FirebaseAnalytics.Param.SCREEN_CLASS, it.javaClass.simpleName)
            }
            firebaseAnalytics.run {
                logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, params)
            }
        }
    }*/


    override fun event(
        event: AnalyticsActions.EVENT
    ) {
        event(event.eventId(), event.eventName())
    }


    override fun event(
        id: String, name: String
    ) {
        val params = Bundle().apply {
            putString(FirebaseAnalytics.Param.ITEM_ID, id)
            putString(FirebaseAnalytics.Param.ITEM_NAME, name)
        }
        firebaseAnalytics.run {
            logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, params)
        }
    }

    override fun eventContent(event: AnalyticsActions.EVENT) {
        eventContent(event.eventId(), event.eventName())
    }

    override fun eventContent(id: String, name: String) {
        val params = Bundle().apply {
            putString(FirebaseAnalytics.Param.ITEM_ID, id)
            putString(FirebaseAnalytics.Param.ITEM_NAME, name)
        }
        firebaseAnalytics.run {
            logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, params)
        }
    }

    override fun eventSelectItem(event: AnalyticsActions.EVENT) {
        eventSelectItem(event.eventId(), event.eventName())
    }

    override fun eventSelectItem(id: String, name: String) {
        val params = Bundle().apply {
            putString(FirebaseAnalytics.Param.ITEM_ID, id)
            putString(FirebaseAnalytics.Param.ITEM_NAME, name)
        }
        firebaseAnalytics.run {
            logEvent(FirebaseAnalytics.Event.SELECT_ITEM, params)
        }
    }

    override fun eventSearch(name: String) {
        val params = Bundle().apply {
            putString(FirebaseAnalytics.Param.ITEM_ID, "click_search")
            putString(FirebaseAnalytics.Param.SEARCH_TERM, name)
        }
        firebaseAnalytics.run {
            logEvent(FirebaseAnalytics.Event.SEARCH, params)
        }
    }
}

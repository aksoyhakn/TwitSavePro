package com.aksoyhakn.twitter.base.activity

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.aksoyhakn.twitter.base.viewmodel.BaseViewModel
import com.aksoyhakn.twitter.extensions.*
import com.aksoyhakn.twitter.ui.common.LottieProgressDialog
import com.aksoyhakn.twitter.utils.AutoClearedActivityValue
import com.aksoyhakn.twitter.utils.analytics.FirebaseAnalyticsHelper
import hideKeyboard
import javax.inject.Inject

/**
 * Created by hakanaksoy on 17.12.22.
 * NargileyeFısıldayanAdam
 */

abstract class BaseActivity<T : ViewDataBinding>(
    var layoutID: Int
) : AppCompatActivity() {

    protected var dataBinding: T by AutoClearedActivityValue()

    private var activityLoading: LottieProgressDialog? = null

    @Inject
    lateinit var firebaseAnalyticsHelper: FirebaseAnalyticsHelper

    fun getBaseViewModel(): BaseViewModel? = null

    open fun bindScreen() {
        dataBinding.lifecycleOwner = this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        dataBinding = DataBindingUtil.setContentView(this, layoutID)
        setToolbar()
        bindScreen()

        toogleLoading()
        toogleErrorOrFail()
    }

    private fun toogleLoading() {
        getBaseViewModel()?.activityLoading?.observe(this, Observer {
            if (it) {
                showLoading()
            } else {
                handler(200) {
                    hideLoading()
                }
            }
        })
    }

    private fun toogleErrorOrFail() {
        getBaseViewModel()?.activityErrorOrFail?.observe(this, Observer {
            hideLoading()
            showDialog(it, {
                onBackPressed()
            }, {
                onBackPressed()
            }
            )
        })
    }

    private fun setToolbar() {
        this.initStatusBar()
    }

    fun showLoading() {
        hideLoading()
        activityLoading.isNull {
            activityLoading = LottieProgressDialog(this)
        }
        activityLoading?.show()
    }

    fun hideLoading() {
        activityLoading.notNull { it.cancel() }
    }

    fun closeKeyboard() {
        hideKeyboard()
    }

    fun clickBack() {
        hideKeyboard()
        onBackPressed()
    }


    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            super.onBackPressed()
        } else {
            hideKeyboard()
            finish()
        }
    }

}
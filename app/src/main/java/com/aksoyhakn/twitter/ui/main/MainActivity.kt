package com.aksoyhakn.twitter.ui.main

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.aksoyhakn.twitter.R
import com.aksoyhakn.twitter.extensions.initStatusBar
import com.google.android.gms.ads.MobileAds
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.OkHttpClient
import okhttp3.Request

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        MobileAds.initialize(this)
        initStatusBar()
        navController = findNavController(R.id.nav_host_fragment)
    }

    companion object {
        var remoteCounter = 10
        var pageCounter = 0
        var isShowRewards: Boolean? = false
    }
}
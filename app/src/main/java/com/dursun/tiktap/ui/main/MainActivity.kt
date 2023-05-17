package com.dursun.tiktap.ui.main

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.dursun.tiktap.R
import com.dursun.tiktap.extensions.initStatusBar
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

        //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO_TIME);
        MobileAds.initialize(this)
        initStatusBar()
        navController = findNavController(R.id.nav_host_fragment)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                navController.navigateUp()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun httpHeadRequestCoroutine() {
        val httpClient: OkHttpClient = OkHttpClient.Builder()
            .build()

        val requestHead = Request.Builder().head().url("https://vm.tiktok.com/ZMYnCykoQ/").head().build()
        var response = httpClient.newCall(requestHead).execute()
        Log.d("Hakan",response.toString())

    }


    companion object {
        var remoteCounter = 10
        var pageCounter = 0
        var isShowRewards: Boolean? = false
    }
}
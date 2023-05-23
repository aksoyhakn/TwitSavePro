package com.aksoyhakn.twitter.ui.main.downloaad

import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.coroutineScope
import com.aksoyhakn.twitter.BuildConfig
import com.aksoyhakn.twitter.R
import com.aksoyhakn.twitter.base.fragment.BaseFragment
import com.aksoyhakn.twitter.base.viewmodel.BaseViewModel
import com.aksoyhakn.twitter.databinding.FragmentDownloadBinding
import com.aksoyhakn.twitter.extensions.*
import com.aksoyhakn.twitter.ui.main.MainActivity.Companion.isShowRewards
import com.aksoyhakn.twitter.ui.main.MainActivity.Companion.pageCounter
import com.aksoyhakn.twitter.ui.main.MainActivity.Companion.remoteCounter
import com.aksoyhakn.twitter.ui.main.downloaad.showTikTok.ShowtikTokBottomSheet
import com.aksoyhakn.twitter.ui.main.downloaad.tiktokModel.TikTokResponse
import dagger.hilt.android.AndroidEntryPoint
import hideKeyboard
import kotlinx.coroutines.launch
import okhttp3.*
import java.io.IOException
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine
import kotlin.toString

/**
 * Created by hakanaksoy on 17.12.22.
 * NargileyeFısıldayanAdam
 */

@AndroidEntryPoint
class DownloadFragment : BaseFragment<FragmentDownloadBinding>(R.layout.fragment_download) {

    var showtikTokBottomSheet: ShowtikTokBottomSheet? = null

    var data: TikTokResponse? = null

    private val viewModel by viewModels<DownloadViewModel>()

    override fun getBaseViewModel(): BaseViewModel = this.viewModel

    override fun bindScreen() {
        dataBinding.viewModel = viewModel
        dataBinding.fragment = this

        if (BuildConfig.DEBUG) {
            dataBinding.adDebugView.visibility = View.VISIBLE
            dataBinding.adDebugView.showAdView()
        } else {
            dataBinding.adReleaseView.visibility = View.VISIBLE
            dataBinding.adReleaseView.showAdView()
        }

        observeDownloadTikTok()
        initListenerSearch()

    }

    fun clickHide() {
        requireContext().hideKeyboard(dataBinding.edtInput)
    }

    private fun observeDownloadTikTok() {

        viewModel.downloadResponse.observe(this) {
            viewModel.getTikTokURL(it.itemInfo?.itemStruct?.video?.downloadAddr)
        }

        viewModel.downloadURL.observe(this) {
            showAds(it)
        }

    }

    private fun initListenerSearch() {
        dataBinding.edtInput.onTextChanged { s, i, i2, i3 ->

            if (s.toString().contains("tiktok.com")) {
                showLoading()
                lifecycle.coroutineScope.launch { // launching a coroutine
                    val result = makeRequest(s.toString())

                    val itemID = "\\d.*?.\\?".toRegex().find(result)?.value?.replace("?","")
                    itemID?.let {
                        viewModel.downloadTikTok(it)
                    }
                }
            }
        }
    }

    private fun initClipBoard() {
        context?.getFromClipBoard()?.let {
            if (it.contains("tiktok.com") && it != dataBinding.edtInput.text.toString()) {
                dataBinding.edtInput.setText(it)
            }
        }
    }

    private fun openBottomSheet(data: TikTokResponse? = null, url: TikTokURL? = null) {

        pageCounter += 1
        if (pageCounter.mod(remoteCounter) == 0) {
            context?.showInterstitialAd {
                it?.show(requireActivity())
            }
        }

        showtikTokBottomSheet = ShowtikTokBottomSheet.newInstance(data,url) {
            context?.clearClipBoard()
            dataBinding.edtInput.text?.clear()
        }
        showtikTokBottomSheet?.showBottomSheet(requireActivity().supportFragmentManager)
    }

    private fun showAds(tikTokURL: TikTokURL? = null) {

        openBottomSheet(data,tikTokURL)

        /*context?.showRewardedAd {
            it?.let {
                isShowRewards = true
                it.show(requireActivity()) {}
            } ?: kotlin.run {
                openBottomSheet(data)
            }
        }

         */
    }

    override fun onResume() {
        super.onResume()

        if (isAdded) {
            dataBinding.clRoot.post {
                initClipBoard()
            }
        }

        if (isShowRewards != false) {
            isShowRewards = false
            openBottomSheet(data)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        context?.clearClipBoard()
    }

    override fun onPause() {
        super.onPause()
        if (isShowRewards != true) {
            if (showtikTokBottomSheet?.isVisible != false) {
                showtikTokBottomSheet?.dismissBottomSheet()
            }
            context?.clearClipBoard()
            dataBinding.edtInput.text?.clear()
        }
    }

    fun clickPremium() {
        preferenceHelper.setQuestToken(null)
    }

    private suspend fun makeRequest(link: String): String = suspendCoroutine { continuation ->
        val client = OkHttpClient()
        val request: Request = Request.Builder()
            .url(link)
            .head()
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                response.use {
                    continuation.resume(response.networkResponse?.request?.url.toString())
                }
            }
        })

    }
}

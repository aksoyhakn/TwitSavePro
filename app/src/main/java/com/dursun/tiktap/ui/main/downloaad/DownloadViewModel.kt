package com.dursun.tiktap.ui.main.downloaad

import androidx.lifecycle.viewModelScope
import com.dursun.tiktap.base.viewmodel.BaseViewModel
import com.dursun.tiktap.data.service.util.State
import com.dursun.tiktap.extensions.notNull
import com.dursun.tiktap.ui.main.downloaad.tiktokModel.TikTokResponse
import com.dursun.tiktap.ui.main.downloaad.twitterModel.GuestTokenResponse
import com.dursun.tiktap.ui.main.downloaad.twitterModel.TwitterResponse
import com.dursun.tiktap.utils.SingleLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by hakanaksoy on 17.12.22.
 * NargileyeFısıldayanAdam
 */

@HiltViewModel
class DownloadViewModel @Inject constructor(
    private val downloadRepository: DownloadRepository
) : BaseViewModel() {

    var downloadResponse = SingleLiveData<TikTokResponse>()
    var twitterResponse = SingleLiveData<TwitterResponse>()
    var questToken = SingleLiveData<GuestTokenResponse>()

    fun downloadTikTok(
        itemId: String? = null
    ) {
        viewModelScope.launch {
            downloadRepository.downloadTikTok(
                itemId ?: ""
            ).collect {
                when (it) {

                    is State.Success -> {
                        toogleFragmentLoading(false)
                        downloadResponse.value = it.data.body()
                    }
                    is State.Fail -> {
                        toogleFragmentLoading(false)
                        it.baseResponse.friendlyMessage.notNull {
                            fragmentErrorOrFail(it)
                        }
                    }
                    is State.Error -> {
                        toogleFragmentLoading(false)
                        fragmentErrorOrFail(it.throwable)
                    }
                }
            }
        }
    }

    fun getTikTokURL(
        url: String? = null
    ) {
        viewModelScope.launch {
            downloadRepository.getTikTokURL(
                url ?: ""
            ).collect {
                when (it) {
                    is State.Loading -> {
                        toogleFragmentLoading(true)
                    }
                    is State.Success -> {
                        toogleFragmentLoading(false)
                    }
                    is State.Fail -> {
                        toogleFragmentLoading(false)

                    }
                    is State.Error -> {
                        toogleFragmentLoading(false)
                    }
                }
            }
        }
    }


    fun twitter() {
        viewModelScope.launch {
            downloadRepository.twitter().collect {
                when (it) {
                    is State.Loading -> {
                        toogleFragmentLoading(true)
                    }
                    is State.Success -> {
                        toogleFragmentLoading(false)
                        questToken.value = it.data.body()
                    }
                    is State.Fail -> {
                        toogleFragmentLoading(false)
                    }
                    is State.Error -> {
                        toogleFragmentLoading(false)
                    }
                }
            }
        }
    }


    fun twitterDownload(itemId:String) {
        viewModelScope.launch {
            downloadRepository.twitterDownload(itemId).collect {
                when (it) {
                    is State.Loading -> {
                        toogleFragmentLoading(true)
                    }
                    is State.Success -> {
                        twitterResponse.value = it.data.body()
                        toogleFragmentLoading(false)
                    }
                    is State.Fail -> {
                        toogleFragmentLoading(false)
                    }
                    is State.Error -> {
                        toogleFragmentLoading(false)
                    }
                }
            }
        }
    }


}
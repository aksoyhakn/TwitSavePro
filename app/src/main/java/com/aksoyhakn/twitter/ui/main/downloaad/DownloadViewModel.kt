package com.aksoyhakn.twitter.ui.main.downloaad

import androidx.lifecycle.viewModelScope
import com.aksoyhakn.twitter.base.viewmodel.BaseViewModel
import com.aksoyhakn.twitter.data.service.util.State
import com.aksoyhakn.twitter.extensions.notNull
import com.aksoyhakn.twitter.ui.main.downloaad.tiktokModel.TikTokResponse
import com.aksoyhakn.twitter.utils.SingleLiveData
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
    var downloadURL = SingleLiveData<TikTokURL>()

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
                        downloadURL.value = it.data.body()
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
package com.aksoyhakn.twitter.ui.main.downloaad.showTikTok

import androidx.databinding.ObservableField
import com.aksoyhakn.twitter.base.viewmodel.BaseViewModel
import com.aksoyhakn.twitter.ui.main.downloaad.tiktokModel.TikTokResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class ShowTikTokViewModel @Inject constructor() : BaseViewModel() {
    var response = ObservableField<TikTokResponse>()
}
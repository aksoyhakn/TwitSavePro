package com.dursun.tiktap.ui.main.downloaad.showTikTok

import androidx.databinding.ObservableField
import com.dursun.tiktap.base.viewmodel.BaseViewModel
import com.dursun.tiktap.ui.main.downloaad.tiktokModel.TikTokResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class ShowTikTokViewModel @Inject constructor() : BaseViewModel() {
    var response = ObservableField<TikTokResponse>()
}
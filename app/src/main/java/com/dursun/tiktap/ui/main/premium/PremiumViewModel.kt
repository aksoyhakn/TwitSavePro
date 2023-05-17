package com.dursun.tiktap.ui.main.premium

import androidx.lifecycle.MutableLiveData
import com.dursun.tiktap.base.viewmodel.BaseViewModel
import com.dursun.tiktap.ui.main.premium.model.Premium

class PremiumViewModel : BaseViewModel() {

    val premiumList = MutableLiveData<ArrayList<Premium>>()

}
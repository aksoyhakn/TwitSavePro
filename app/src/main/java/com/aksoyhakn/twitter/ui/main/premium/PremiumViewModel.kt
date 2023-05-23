package com.aksoyhakn.twitter.ui.main.premium

import androidx.lifecycle.MutableLiveData
import com.aksoyhakn.twitter.base.viewmodel.BaseViewModel
import com.aksoyhakn.twitter.ui.main.premium.model.Premium

class PremiumViewModel : BaseViewModel() {

    val premiumList = MutableLiveData<ArrayList<Premium>>()

}
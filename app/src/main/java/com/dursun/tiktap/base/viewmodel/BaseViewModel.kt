package com.dursun.tiktap.base.viewmodel

import androidx.lifecycle.ViewModel
import com.dursun.tiktap.utils.SingleLiveData

/**
 * Created by hakanaksoy on 17.12.22.
 * NargileyeFısıldayanAdam
 */

open class BaseViewModel : ViewModel() {
    var activityLoading = SingleLiveData<Boolean>()
    protected fun toogleActivityLoading(status: Boolean) {
        activityLoading.value = status
    }

    var fragmentLoading = SingleLiveData<Boolean>()
    protected fun toogleFragmentLoading(status: Boolean) {
        fragmentLoading.value = status
    }

    var activityErrorOrFail = SingleLiveData<Any>()
    protected fun activityErrorOrFail(status: Any) {
        activityErrorOrFail.value = status
    }

    var fragmentErrorOrFail = SingleLiveData<Any>()
    protected fun fragmentErrorOrFail(status: Any) {
        fragmentErrorOrFail.value = status
    }

}

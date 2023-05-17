package com.dursun.tiktap.base.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentManager
import com.dursun.tiktap.R
import com.dursun.tiktap.base.viewmodel.BaseViewModel
import com.dursun.tiktap.ui.common.LottieProgressDialog
import com.dursun.tiktap.utils.AutoClearedFragmentValue
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/**
 * Created by hakanaksoy on 17.12.22.
 * NargileyeFısıldayanAdam
 */

abstract class BaseBottomSheetDialog<T : ViewDataBinding>(var layoutId: Int) :
    BottomSheetDialogFragment() {


    protected var dataBinding: T by AutoClearedFragmentValue()

    private var progress: LottieProgressDialog? = null

    abstract fun getBaseViewModel(): BaseViewModel

    open fun bindScreen() {
        dataBinding.lifecycleOwner = this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_FRAME, R.style.BottomSheetDialogStyle)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        return dataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        bindScreen().also { bindScreen() }
    }

    fun showBottomSheet(fragmentManager: FragmentManager) {
        show(fragmentManager, "BOTTOM_SHEET")
    }

    fun dismissBottomSheet() {
        dismissAllowingStateLoss()
    }
}
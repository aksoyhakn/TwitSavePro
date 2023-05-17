package com.dursun.tiktap.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.dursun.tiktap.base.viewmodel.BaseViewModel
import com.dursun.tiktap.data.preference.PreferenceHelper
import com.dursun.tiktap.data.preference.PreferenceHelperImp
import com.dursun.tiktap.extensions.*
import com.dursun.tiktap.ui.common.LottieProgressDialog
import com.dursun.tiktap.ui.main.MainActivity.Companion.pageCounter
import com.dursun.tiktap.ui.main.MainActivity.Companion.remoteCounter
import com.dursun.tiktap.utils.AutoClearedFragmentValue
import com.dursun.tiktap.utils.analytics.FirebaseAnalyticsHelper
import hideKeyboard
import javax.inject.Inject

/**
 * Created by hakanaksoy on 17.12.22.
 * NargileyeFısıldayanAdam
 */

abstract class BaseFragment<T : ViewDataBinding>(var layoutId: Int) : Fragment() {

    protected var dataBinding: T by AutoClearedFragmentValue()

    private var progress: LottieProgressDialog? = null

    @Inject
    lateinit var firebaseAnalyticsHelper: FirebaseAnalyticsHelper

    @Inject
    lateinit var preferenceHelper: PreferenceHelperImp


    abstract fun getBaseViewModel(): BaseViewModel

    open fun bindScreen() {
        dataBinding.lifecycleOwner = this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(
            inflater,
            layoutId,
            container,
            false
        )
        dataBinding.lifecycleOwner = this
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindScreen()

        toogleLoading()
        toogleErrorOrFail()

    }

    private fun toogleLoading() {
        getBaseViewModel().fragmentLoading.observe(viewLifecycleOwner) {
            if (it) {
                showLoading()
            } else {
                requireContext().handler(200) {
                    hideLoading()
                }
            }
        }
    }

    private fun toogleErrorOrFail() {
        getBaseViewModel().fragmentErrorOrFail.observe(viewLifecycleOwner) {
            hideLoading()
            requireContext().showDialog(it, {
                activity?.onBackPressed()
            }, {
                activity?.onBackPressed()
            })
        }
    }

    fun showLoading() {
        hideLoading()
        this.context.notNull { context ->
            progress.isNull {
                progress = LottieProgressDialog(context)
            }
            progress?.show()
        }
    }

    fun hideLoading() {
        progress.notNull { it.cancel() }
    }

    fun closeKeyboard() {
        requireContext().hideKeyboard()
    }

}
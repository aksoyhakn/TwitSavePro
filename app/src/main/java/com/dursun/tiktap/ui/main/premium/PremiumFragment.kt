package com.dursun.tiktap.ui.main.premium

import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.dursun.tiktap.R
import com.dursun.tiktap.base.fragment.BaseFragment
import com.dursun.tiktap.base.viewmodel.BaseViewModel
import com.dursun.tiktap.databinding.FragmentPremiumBinding
import com.dursun.tiktap.ui.main.premium.adapter.PremiumAdapter
import com.dursun.tiktap.ui.main.premium.model.Premium
import com.dursun.tiktap.utils.Constants
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by hakanaksoy on 17.12.22.
 * NargileyeFısıldayanAdam
 */

@AndroidEntryPoint
class PremiumFragment : BaseFragment<FragmentPremiumBinding>(R.layout.fragment_premium),
    PremiumAdapter.ListenerPremium {

    private val viewModel by viewModels<PremiumViewModel>()

    private val premiumList: ArrayList<Premium>? by lazy {
        arguments?.getParcelableArrayList(Constants.Main.PREMIUM_DATA)
    }

    override fun getBaseViewModel(): BaseViewModel = this.viewModel

    override fun bindScreen() {
        dataBinding.viewModel = viewModel
        dataBinding.fragment = this
        dataBinding.listener = this
        viewModel.premiumList.value = premiumList

    }

    fun clickHide() {
        Navigation.findNavController(requireView()).popBackStack()
    }

    override fun clickPremium(item: Premium) {

    }

}
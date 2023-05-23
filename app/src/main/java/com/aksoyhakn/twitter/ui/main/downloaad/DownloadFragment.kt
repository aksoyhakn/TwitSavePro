package com.aksoyhakn.twitter.ui.main.downloaad

import androidx.fragment.app.viewModels
import com.aksoyhakn.twitter.R
import com.aksoyhakn.twitter.base.fragment.BaseFragment
import com.aksoyhakn.twitter.base.viewmodel.BaseViewModel
import com.aksoyhakn.twitter.databinding.FragmentDownloadBinding
import dagger.hilt.android.AndroidEntryPoint
/**
 * Created by hakanaksoy on 17.12.22.
 * NargileyeFısıldayanAdam
 */

@AndroidEntryPoint
class DownloadFragment : BaseFragment<FragmentDownloadBinding>(R.layout.fragment_download) {

    private val viewModel by viewModels<DownloadViewModel>()

    override fun getBaseViewModel(): BaseViewModel = this.viewModel

    override fun bindScreen() {
        dataBinding.viewModel = viewModel
        dataBinding.fragment = this

    }
}

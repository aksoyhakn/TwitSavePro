package com.aksoyhakn.twitter.ui.main.downloaad

import com.aksoyhakn.twitter.base.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by hakanaksoy on 17.12.22.
 * NargileyeFısıldayanAdam
 */

@HiltViewModel
class DownloadViewModel @Inject constructor(
    private val downloadRepository: DownloadRepository
) : BaseViewModel() {

}
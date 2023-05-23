package com.aksoyhakn.twitter.ui.main.downloaad

import com.aksoyhakn.twitter.data.service.AppDataSource
import javax.inject.Inject

class DownloadRepository @Inject constructor(
    private val appDataSource: AppDataSource
) {}
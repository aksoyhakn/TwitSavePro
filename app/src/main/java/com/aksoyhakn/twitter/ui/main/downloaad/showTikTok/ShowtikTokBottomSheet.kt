package com.aksoyhakn.twitter.ui.main.downloaad.showTikTok

import android.annotation.SuppressLint
import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.os.Environment
import android.util.Log
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import com.aksoyhakn.twitter.R
import com.aksoyhakn.twitter.base.bottomsheet.BaseBottomSheetDialog
import com.aksoyhakn.twitter.base.viewmodel.BaseViewModel
import com.aksoyhakn.twitter.databinding.FragmentShowtiktokBinding
import com.aksoyhakn.twitter.extensions.notNull
import com.aksoyhakn.twitter.extensions.setBottomSheetState
import com.aksoyhakn.twitter.ui.main.downloaad.tiktokModel.TikTokResponse
import com.aksoyhakn.twitter.utils.Constants
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.aksoyhakn.twitter.ui.main.downloaad.TikTokURL
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShowtikTokBottomSheet(
    var data: TikTokResponse? = null,
    var listener: () -> Unit
) : BaseBottomSheetDialog<FragmentShowtiktokBinding>(R.layout.fragment_showtiktok) {

    companion object {
        fun newInstance(
            data: TikTokResponse?,
            url: TikTokURL?,
            listener: () -> Unit
        ): ShowtikTokBottomSheet {
            val fragment = ShowtikTokBottomSheet(data, listener)
            val bundle = bundleOf(
                Constants.Main.DOWNLOAD_DATA to data,
                Constants.Main.DOWNLOAD_URL to url
            )
            fragment.arguments = bundle
            return fragment
        }
    }

    var downloadId: Long = 0L
    var downloadURL: TikTokURL?= null


    private val viewModel by viewModels<ShowTikTokViewModel>()

    override fun getBaseViewModel(): BaseViewModel = this.viewModel

    override fun bindScreen() {
        dataBinding.fragment = this
        (arguments?.getParcelable<TikTokResponse>(Constants.Main.DOWNLOAD_DATA)).notNull {
            dataBinding.data = it
        }

        (arguments?.getParcelable<TikTokURL>(Constants.Main.DOWNLOAD_URL)).notNull {
            downloadURL = it
        }

        setBottomSheetState(BottomSheetBehavior.STATE_COLLAPSED)
        requireActivity().registerReceiver(
            onDownloadComplete,
            IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE)
        )
    }


    @SuppressLint("Range")
    fun videoDownload(data: TikTokResponse?, status: Int? = 0) {
        val request = DownloadManager.Request(
                Uri.parse(
                    downloadURL?.url
                )
            )
                .setTitle(
                    if (status == 0) {
                        "VIDEO"
                    } else {
                        "MUSIC"
                    }
                )
                .setDescription("Downloading")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setAllowedOverMetered(true)
                .setVisibleInDownloadsUi(true)

       /* request.addRequestHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.121 Safari/537.36")
        request.addRequestHeader("Origin", "https://www.tiktok.com")
        request.addRequestHeader("Referer", "https://www.tiktok.com")
        request.addRequestHeader("Sec-Fetch-Dest", "empty")
        request.addRequestHeader("Sec-Fetch-Mode", "cors")
        request.addRequestHeader("Sec-Fetch-Site", "cross-site")*/

        request.setDestinationInExternalPublicDir(
            Environment.DIRECTORY_DOWNLOADS,
            "twitter.mp4"
        )

        request.allowScanningByMediaScanner()
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)


        val dm = context?.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        downloadId = dm.enqueue(request)


        // using query method
        var finishDownload = false;
        var progress: Int
        while (!finishDownload) {
            var cursor = dm.query(DownloadManager.Query().setFilterById(downloadId));
            if (cursor.moveToFirst()) {
                var status = cursor?.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS))

                when (status) {
                    DownloadManager.STATUS_FAILED -> {
                        Log.d("HAKAN","STATUS_FAILED")
                        finishDownload = true;
                    }
                    DownloadManager.STATUS_RUNNING -> {
                        Log.d("HAKAN","STATUS_RUNNING")

                        var total =
                            cursor.getLong(cursor.getColumnIndex(DownloadManager.COLUMN_TOTAL_SIZE_BYTES));
                        if (total >= 0) {
                            var downloaded = cursor.getLong(cursor.getColumnIndex(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR));
                            progress = (((downloaded * 100L) / total).toInt())
                        }
                    }
                    DownloadManager.STATUS_SUCCESSFUL -> {
                        progress = 100;
                        finishDownload = true;
                        Log.d("HAKAN","STATUS_SUCCESSFUL")
                        Toast.makeText(context, "Download Completed", Toast.LENGTH_SHORT).show();
                    }
                    else ->{
                        Log.d("HAKAN","ELSE")
                    }
                }
            }

        }
    }

    private var onDownloadComplete = object : BroadcastReceiver() {
        override fun onReceive(p0: Context?, p1: Intent?) {
            val id = p1?.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1)
            if (downloadId == id) {
                listener()
                dismissBottomSheet()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        requireActivity().unregisterReceiver(onDownloadComplete)
        listener()
        dismissBottomSheet()
    }

}
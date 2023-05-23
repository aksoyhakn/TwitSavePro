package com.aksoyhakn.twitter.ui.common.bindingadapters

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.graphics.PorterDuff
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import com.aksoyhakn.twitter.R
import com.aksoyhakn.twitter.extensions.*
import com.tistory.zladnrms.roundablelayout.RoundableLayout

/**
 * Created by hakanaksoy on 17.12.22.
 * NargileyeFısıldayanAdam
 */

object ViewBindingAdapters {

    @JvmStatic
    @BindingAdapter("bind:setImageCache")
    fun setImageCache(view: ImageView, url: String?) {
        url.notNull {
            if (!url!!.contains(".gif")) {
                view.loadGlideImageCache(
                    view.context,
                    url,
                    null
                )
            } else {
                view.loadGIF(view.context, url)
            }
        }

    }


    @JvmStatic
    @BindingAdapter("onSafeClick")
    fun onSafeClick(view: View, listener: View.OnClickListener) {
        view.setSafeOnClickListener {
            listener.onClick(view)
        }
    }


}


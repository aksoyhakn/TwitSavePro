package com.dursun.tiktap.ui.common.component.button

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.dursun.tiktap.R
import com.dursun.tiktap.databinding.ComponentBannerviewBinding
import com.dursun.tiktap.databinding.ComponentButtonBinding
import com.dursun.tiktap.extensions.resColor

/**
 * Created by hakanaksoy on 17.12.22.
 * NargileyeFısıldayanAdam
 */


class BannerView : RelativeLayout {

    private lateinit var databinding: ComponentBannerviewBinding

    constructor(context: Context?) : super(context) {
        init(context, null)
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(context, attrs)
    }


    private fun init(context: Context?, attrs: AttributeSet?) {
        databinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.component_bannerview,
                this,
                true
            )
    }
}
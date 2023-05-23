package com.aksoyhakn.twitter.extensions

import android.os.Bundle
import androidx.core.os.bundleOf

/**
 * Created by hakanaksoy on 17.12.22.
 * NargileyeFısıldayanAdam
 */


fun Bundle.putAny(key: String, value: Any?) {
    putAll(bundleOf(key to value))
}
package com.dursun.tiktap.extensions

import android.content.Context
import java.io.IOException
import java.nio.charset.Charset
import kotlin.jvm.Throws

@Throws(IOException::class)
fun Context.loadJSONFromAsset(jsonFileName: String): String {
    (this.assets).open(jsonFileName).let {
        val buffer = ByteArray(it.available())
        it.read(buffer)
        it.close()
        return String(buffer, Charset.forName("UTF-8"))
    }
}
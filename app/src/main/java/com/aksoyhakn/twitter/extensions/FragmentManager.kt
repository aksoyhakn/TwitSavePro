package com.aksoyhakn.twitter.extensions

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.provider.Settings
import androidx.core.app.ActivityCompat
import androidx.core.content.PermissionChecker
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.aksoyhakn.twitter.R
import com.aksoyhakn.twitter.data.preference.PreferenceHelperImp

internal fun FragmentManager.removeFragment(
    tag: String,
    slideIn: Int = R.anim.slide_left,
    slideOut: Int = R.anim.slide_right
) {
    findFragmentByTag(tag)?.let {
        this.beginTransaction()
            .disallowAddToBackStack()
            .setCustomAnimations(slideIn, slideOut)
            .remove(it)
            .commitNow()
    }
}

internal fun FragmentManager.removeFragment(
    slideIn: Int = R.anim.slide_left,
    slideOut: Int = R.anim.slide_right
) {
    this.beginTransaction()
        .disallowAddToBackStack()
        .setCustomAnimations(slideIn, slideOut)
        .commitNow()
}

internal fun FragmentManager.addFragment(
    containerViewId: Int,
    fragment: Fragment,
    tag: String,
    slideIn: Int = R.anim.slide_left,
    slideOut: Int = R.anim.slide_right
) {
    this.beginTransaction().disallowAddToBackStack()
        .setCustomAnimations(slideIn, slideOut)
        .add(containerViewId, fragment, tag)
        .commit()
}

val READ_EXTERNAL_STORAGE_PERMISSION = arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE)
/*
* Asks permission if needed from fragment
*/
fun Fragment.askPermissionIfNeeded(
    permissions: Array<String>,
    requestCode: Int,
    prefence: PreferenceHelperImp? = null,
    onPermissionsNotGranted: ((@ParameterName(name = "permissions") Array<String>) -> Unit)? = null,
    onAllPermissionsGranted: (() -> Unit)? = null
) {
    val deniedPermissions = context?.let { READ_EXTERNAL_STORAGE_PERMISSION.removeGrantedPermissions(it) }

    if (deniedPermissions?.isEmpty() == true) {
        onAllPermissionsGranted?.invoke()
    } else {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (prefence?.getIsFirstApp() != false) {
                prefence?.setIsFirstApp(false)
                requestPermissions(permissions, requestCode)
            } else {
                onPermissionsNotGranted?.let {
                    onPermissionsNotGranted.invoke(permissions)
                } ?: deniedPermissions?.let {
                    requestPermissions(it, requestCode)
                }
            }
        }
    }
}

/*
* Checks if permissions granted or not
*/
fun Array<String>.isCheckPermissionGranted(context: Context): Boolean {
    for (permission in this) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (context.checkSelfPermission(permission) == PackageManager.PERMISSION_DENIED) {
                return false
            }
        }
    }
    return true
}

/*
* Removes granted permissions
*/
fun Array<String>.removeGrantedPermissions(context: Context): Array<String> {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        filter { PermissionChecker.checkSelfPermission(context, it) != PermissionChecker.PERMISSION_GRANTED  }.toTypedArray()
    } else {
        emptyArray()
    }
}


/*
 * Permission check extension
 */
fun Array<String>.isPermissionsGranted(context: Context): Boolean {
    for (i in this.indices) {
        if (ActivityCompat.checkSelfPermission(context, this[i]) != PackageManager.PERMISSION_GRANTED) {
            return false
        }
    }
    return true
}

fun Activity.navigateToSettings() {
    val intent = Intent()
    intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
    val uri: Uri = Uri.fromParts("package", packageName, null)
    intent.data = uri
    startActivity(intent)
}

fun hasReadStoragePermission(context: Context) = ActivityCompat.checkSelfPermission(
    context,
    Manifest.permission.READ_EXTERNAL_STORAGE
) == PackageManager.PERMISSION_GRANTED



package com.aksoyhakn.twitter.ui.main.splash

import android.Manifest
import android.content.pm.PackageManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.aksoyhakn.twitter.R
import com.aksoyhakn.twitter.base.fragment.BaseFragment
import com.aksoyhakn.twitter.base.viewmodel.BaseViewModel
import com.aksoyhakn.twitter.data.service.model.FriendlyMessage
import com.aksoyhakn.twitter.databinding.FragmentSplashBinding
import com.aksoyhakn.twitter.extensions.*
import com.aksoyhakn.twitter.ui.main.MainActivity.Companion.remoteCounter
import com.aksoyhakn.twitter.ui.main.splash.model.RemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import java.net.UnknownHostException


/**
 * Created by hakanaksoy on 17.12.22.
 * NargileyeFısıldayanAdam
 */


@AndroidEntryPoint
class SplashFragment :
    BaseFragment<FragmentSplashBinding>(R.layout.fragment_splash) {

    private val viewModel by viewModels<SplashViewModel>()

    override fun getBaseViewModel(): BaseViewModel = this.viewModel

    private var data: RemoteConfig? = null

    override fun bindScreen() {

        val animZoomIn: Animation = AnimationUtils.loadAnimation(context, R.anim.splash_anim)
        animZoomIn.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(p0: Animation?) {}
            override fun onAnimationEnd(p0: Animation?) {
                context?.isOnline {
                    if (it) {
                        initRemoteConfig()
                    } else {
                        requireContext().showDialog(UnknownHostException(), {}, {})
                    }
                }
            }

            override fun onAnimationRepeat(p0: Animation?) {}
        })
        dataBinding.clRoot.startAnimation(animZoomIn)

        Navigation.findNavController(dataBinding.root)
            .navigate(R.id.action_splashFragment_to_homeFragment)

    }

    override fun onResume() {
        super.onResume()
        //initRemoteConfig()
    }

    private fun initRemoteConfig() {

        val remoteConfig: FirebaseRemoteConfig = FirebaseRemoteConfig.getInstance()
        val configSettings = FirebaseRemoteConfigSettings.Builder()
            .setMinimumFetchIntervalInSeconds(360L)
            .build()

        remoteConfig.setConfigSettingsAsync(configSettings)
        remoteConfig.fetchAndActivate()
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    var remoteJson: String? = remoteConfig.getString("and_remote_config")
                    remoteJson?.takeIf { it.isNotBlank() }?.apply {
                        data = Gson().fromJson(
                            this,
                            RemoteConfig::class.java
                        )

                        askPermissionIfNeeded(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                            101,
                            prefence = preferenceHelper,
                            onAllPermissionsGranted = {
                                navigateToDashboard(
                                    data
                                )
                            },
                            onPermissionsNotGranted = {
                                preferenceHelper.setIsFirstApp(false)
                                requireContext().showDialog(
                                    FriendlyMessage(
                                        resString(R.string.per_new_version),
                                        resString(R.string.per_new_version_description),
                                        false,
                                        resString(R.string.per_new_version_cancel),
                                        resString(R.string.per_new_version_ok),
                                        ""
                                    ),
                                    {
                                        requireActivity().navigateToSettings()
                                    },
                                    {
                                        requireActivity().finish()
                                    }
                                )
                            })


                    }
                } else {
                    requireContext().showDialog(UnknownHostException(), {}, {})
                }
            }
            .addOnFailureListener { exception ->
                requireContext().showDialog(UnknownHostException(), {}, {})
            }
            .addOnCanceledListener {
                requireContext().showDialog(UnknownHostException(), {}, {})
            }
    }

    private fun navigateToDashboard(data: RemoteConfig?) {
        remoteCounter = data?.pageCounter ?: 4
        if (data?.isForceUpdate != true) {

            context?.handler(500) {
                Navigation.findNavController(dataBinding.root)
                    .navigate(R.id.action_splashFragment_to_homeFragment)
            }

        } else {

            context?.handler(500) {
                requireContext().showDialog(
                    FriendlyMessage(
                        resString(R.string.new_version),
                        resString(R.string.new_version_description),
                        false,
                        resString(R.string.new_version_cancel),
                        resString(R.string.new_version_ok),
                        ""
                    ),
                    {
                        requireContext().openMarket()
                    },
                    {
                        requireActivity().finish()
                    }
                )
            }

        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            101 -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    navigateToDashboard(
                        data
                    )
                } else {
                    requireActivity().finish()
                }
            }
        }
    }



}
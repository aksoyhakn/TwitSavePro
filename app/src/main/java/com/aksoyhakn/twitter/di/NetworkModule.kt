package com.aksoyhakn.twitter.di

import android.app.Application
import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.aksoyhakn.twitter.BuildConfig
import com.aksoyhakn.twitter.app.AppBase
import com.aksoyhakn.twitter.data.preference.PreferenceHelper
import com.aksoyhakn.twitter.data.preference.PreferenceHelperImp
import com.aksoyhakn.twitter.data.service.LoggingInterceptor
import com.aksoyhakn.twitter.data.service.AppDataSource
import com.aksoyhakn.twitter.data.service.AppService
import com.aksoyhakn.twitter.utils.Constants
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by hakanaksoy on 17.12.22.
 * NargileyeFısıldayanAdam
 */

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    internal fun providePrefFileName(): String = Constants.App.PREF_NAME

    @Provides
    internal fun provideGsonBuilder(): Gson =  GsonBuilder().setLenient().create()

    @Provides
    internal fun providePrefHelper(appPreferenceHelper: PreferenceHelperImp): PreferenceHelper =
        appPreferenceHelper

    @Provides
    fun provideContext(application: Application): Context =
        AppBase.instance.applicationContext

    @Provides
    fun provideChuckInterceptor(application: Application) = ChuckerInterceptor(application)

    @Provides
    fun provideInterceptor(context: Context) = LoggingInterceptor(
        PreferenceHelperImp(context, providePrefFileName())
    )

    @Provides
    fun provideOkHttpClient(
        loggingInterceptor: LoggingInterceptor,
        chuckInterceptor: ChuckerInterceptor
    ): OkHttpClient {
        if (BuildConfig.GADGET_ENABLED) {
            return OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .addInterceptor(chuckInterceptor)
                .build()
        } else {
            return OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .build()
        }
    }


    private fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(provideGsonBuilder()))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }

    @Provides
    @Singleton
    fun provideAppService(okHttpClient: OkHttpClient): AppService {
        return provideRetrofit(okHttpClient).create(AppService::class.java)
    }

    @Provides
    @Singleton
    fun provideAppClient(
        appService: AppService
    ): AppDataSource {
        return AppDataSource(appService)
    }
}
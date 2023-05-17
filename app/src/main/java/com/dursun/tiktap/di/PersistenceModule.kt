package com.dursun.tiktap.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.dursun.tiktap.data.persistence.AppDatabase
import com.dursun.tiktap.data.persistence.TikTakDao
import com.dursun.tiktap.utils.Constants
import com.dursun.tiktap.utils.analytics.AnalyticsHelper
import com.dursun.tiktap.utils.analytics.FirebaseAnalyticsHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by hakanaksoy on 17.12.22.
 * NargileyeFısıldayanAdam
 */

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {


    @Provides
    @Singleton
    fun providesFirebaseAnalyticsHelper(context: Context): AnalyticsHelper =
        FirebaseAnalyticsHelper(context)


    @Provides
    fun provideAppDatabase(
        application: Application
    ): AppDatabase {
        return Room
            .databaseBuilder(application, AppDatabase::class.java, Constants.App.DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideTrendLineDao(appDatabase: AppDatabase): TikTakDao {
        return appDatabase.tikTakDao()
    }

}
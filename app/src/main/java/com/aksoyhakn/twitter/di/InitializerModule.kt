package com.aksoyhakn.twitter.di

import com.aksoyhakn.twitter.app.initializers.AppInitializer
import com.aksoyhakn.twitter.app.initializers.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet


/**
 * Created by hakanaksoy on 17.12.22.
 * NargileyeFısıldayanAdam
 */

@Module
@InstallIn(SingletonComponent::class)
object InitializerModule {

    @Provides
    @IntoSet
    fun provideFirebaseInitializer(): AppInitializer = FirebaseInitializer()

    @Provides
    @IntoSet
    fun provideCrashlyticsInitializer(): AppInitializer = CrashlyticsInitializer()

    @Provides
    @IntoSet
    fun provideAdaptyInitializer(): AppInitializer = AdaptyInitializer()
}

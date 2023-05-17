package com.dursun.tiktap.data.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dursun.tiktap.data.persistence.entity.Data

/**
 * Created by hakanaksoy on 17.12.22.
 * NargileyeFısıldayanAdam
 */

@Database(entities = [Data::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun tikTakDao(): TikTakDao
}
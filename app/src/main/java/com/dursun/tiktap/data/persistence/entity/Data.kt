package com.dursun.tiktap.data.persistence.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by hakanaksoy on 17.12.22.
 * NargileyeFısıldayanAdam
 */

@Entity
data class Data(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val data: String
)
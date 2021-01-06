package com.saregama.mvvmmusicapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.saregama.mvvmmusicapp.BuildConfig


@Database(
        entities = [DeviceEntity::class],
        version = BuildConfig.VERSION_CODE,
        exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract val deviceDao: DeviceDao
}
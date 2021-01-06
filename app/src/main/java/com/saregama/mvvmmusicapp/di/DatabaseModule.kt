package com.saregama.mvvmmusicapp.di

import androidx.room.Room
import com.saregama.mvvmmusicapp.App
import com.saregama.mvvmmusicapp.room.AppDatabase
import com.saregama.mvvmmusicapp.room.DeviceDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(app: App): AppDatabase {
        return Room.databaseBuilder(app, AppDatabase::class.java, "wasa.db")
                .fallbackToDestructiveMigration()
                .build()
    }

    @Provides
    @Singleton
    fun provideDeviceDao(db: AppDatabase): DeviceDao = db.deviceDao
}
package com.saregama.mvvmmusicapp.di

import android.app.Application
import dagger.Module
import dagger.Provides


@Module(includes = [DatabaseModule::class, NetworkModule::class, ViewModelModule::class])
internal object AppModule {
    // If you need.

/*    *//**
     * Application instance.
     *//*
    private val application: Application? = null

    *//**
     * Constructor for AppModule.
     * @param application the application instance.
     *//*
    fun AppModule(application: Application?) {
        this.application = application
    }

    *//**
     * Provide application context.
     *//*
    @Provides
    @ApplicationContext
    fun provideAppContext(): Context? {
        return application
    }*/
}

package com.saregama.mvvmmusicapp.di

import com.saregama.mvvmmusicapp.MainActivity
import com.saregama.mvvmmusicapp.SplashActivity
import com.saregama.mvvmmusicapp.SplashViewModel
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [MainModule::class])
    internal abstract fun contributeMainInjector(): MainActivity
}
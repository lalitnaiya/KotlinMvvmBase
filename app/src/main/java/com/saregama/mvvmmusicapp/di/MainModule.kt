package com.saregama.mvvmmusicapp.di

import com.saregama.mvvmmusicapp.ui.home.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class MainModule {

    @ContributesAndroidInjector
    internal abstract fun contributeTopFragmentInjector(): HomeFragment
}
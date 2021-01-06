package com.saregama.mvvmmusicapp.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.saregama.mvvmmusicapp.SplashViewModel
import com.saregama.mvvmmusicapp.ui.MainViewModel
import com.saregama.mvvmmusicapp.ui.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module(includes = [RepositoryModule::class])
interface ViewModelModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

//    @Binds
//    @IntoMap
//    @ViewModelKey(DeviceViewModel::class)
//    fun bindDeviceViewModel(viewModel: DeviceViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    fun bindSplashViewModel(viewModel: SplashViewModel): ViewModel



//    @Binds
//    @IntoMap
//    @ViewModelKey(HomeViewModel::class)
//    fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel
}
package com.saregama.mvvmmusicapp.di

import com.saregama.mvvmmusicapp.data.repository.ConfigRepository
import com.saregama.mvvmmusicapp.data.repository.Config
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {

    @Binds
    fun bindPlanetRepository(repository: ConfigRepository): Config


}
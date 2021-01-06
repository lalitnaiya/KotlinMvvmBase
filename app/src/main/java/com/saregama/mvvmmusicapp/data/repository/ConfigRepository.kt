package com.saregama.mvvmmusicapp.data.repository

import com.saregama.mvvmmusicapp.data.local.ApodOfConfig
import com.saregama.mvvmmusicapp.data.remote.ConfigDataSource
import io.reactivex.Flowable
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class ConfigRepository @Inject constructor(
    private val configDataSource: ConfigDataSource
) : Config {

    override fun getInfo(model: String): Flowable<ApodOfConfig> {
        return configDataSource.getInfo()
    }
}
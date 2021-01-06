package com.saregama.mvvmmusicapp.data.repository

import com.saregama.mvvmmusicapp.data.local.ApodOfConfig
import io.reactivex.Flowable
import kotlinx.coroutines.flow.Flow


interface Config {
    fun getInfo(model: String): Flowable<ApodOfConfig>
}
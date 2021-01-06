package com.saregama.mvvmmusicapp.data.remote

import com.saregama.mvvmmusicapp.data.local.ApodOfConfig
import io.reactivex.Flowable
import io.reactivex.Single
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ConfigService {

    //    ${Constants.v1}type=config
    @GET("v1/?type=config&model=c_music")
    fun getInfo(@Query("c_music") key: String): Flowable<ApodOfConfig>

}
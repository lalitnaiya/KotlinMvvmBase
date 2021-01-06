package com.saregama.mvvmmusicapp.data.remote

import javax.inject.Inject

class ConfigDataSource @Inject constructor(private val configService: ConfigService) {
    fun getInfo() = configService.getInfo("c_music")
}
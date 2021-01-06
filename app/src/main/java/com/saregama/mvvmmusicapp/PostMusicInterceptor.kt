package com.saregama.mvvmmusicapp

import com.saregama.mvvmmusicapp.di.Qualifiers
import com.saregama.mvvmmusicapp.util.Factory
import com.saregama.mvvmmusicapp.util.Utils
import okhttp3.*
import java.io.IOException

class PostMusicInterceptor : Interceptor, Authenticator {

    /**
     * Interceptor class for setting of the headers for every request
     */
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request?.newBuilder()
            ?.header("Content-Type", "application/json")
            ?.header("Accept", "application/json")
            ?.header(Qualifiers.header_device_id, Utils.encode(Factory.getDeviceId()))
            ?.header(Qualifiers.header_auth_key, Factory.getAuthKey())
            ?.header(Qualifiers.header_playon, Qualifiers.header_music)
            ?.header("name", Utils.encode(Factory.getDeviceName()))
            ?.header("os_v", Utils.encode(Factory.getOSVersion()))
            ?.header("app_v", Utils.encode(Factory.getAppVersion()))
            ?.build()
        return chain.proceed(request)
    }

    /**
     * Authenticator for when the authToken need to be refresh and updated
     * everytime we get a 401 error code
     */


    @Throws(IOException::class)
    override fun authenticate(route: Route?, response: Response): Request? {
        var requestAvailable: Request? = null
        try {
            requestAvailable = response?.request.newBuilder()
                ?.build()
            return requestAvailable
        } catch (ex: Exception) {
        }
        return requestAvailable
    }

}
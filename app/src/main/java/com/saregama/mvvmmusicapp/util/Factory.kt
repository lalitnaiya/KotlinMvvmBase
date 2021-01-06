package com.saregama.mvvmmusicapp.util

import android.os.Build
import android.provider.Settings
import com.google.gson.Gson
import com.saregama.mvvmmusicapp.App
import com.saregama.mvvmmusicapp.data.local.User
import com.saregama.mvvmmusicapp.di.Qualifiers.SECRET_KEY
import java.math.BigInteger
import java.security.MessageDigest

object Factory {

    fun getUser(): User? {
        if (App.getContext().prefs.userDetail!!.isNotEmpty()) {
            return Gson().fromJson(App.getContext().prefs.userDetail, User::class.java)
        } else {
            return null
        }
    }


    fun getDeviceName(): String {
        return Build.MODEL
    }

    fun getOSVersion(): String {
        return "${Build.VERSION.SDK_INT}_${Build.VERSION_CODES.BASE}_${Build.VERSION.RELEASE}"
    }

    fun getAppVersion(): String {
        var version = ""
        val pInfo = App.getContext().packageManager.getPackageInfo(App.getContext().packageName, 0)
        version = pInfo.versionName
        return version

    }

    fun getDeviceId(): String {
        var deviceId = "No permission from user"
        try {

            deviceId = Settings.Secure.getString(
                App.getContext().contentResolver,
                Settings.Secure.ANDROID_ID
            )
//            Logger.d("deviceId = " + deviceId)
        } catch (e: SecurityException) {
        }
        return deviceId
    }

    fun getAuthKey(): String = (SECRET_KEY + getDeviceId()).md5()

    fun String.md5(): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
    }

}
package com.saregama.mvvmmusicapp.util

import android.content.Context
import android.content.SharedPreferences
import com.saregama.mvvmmusicapp.di.Qualifiers.USER_DETAIL

class PreferenceUtils(context: Context) {


    private val SHARED_PREFERENCE_FILE_NAME = "music_carvaan"
    val prefs: SharedPreferences = context.getSharedPreferences(SHARED_PREFERENCE_FILE_NAME, 0)

    var userDetail: String?
        get() = prefs.getString(USER_DETAIL, "")
        set(value) = prefs.edit().putString(USER_DETAIL, value).apply()
}
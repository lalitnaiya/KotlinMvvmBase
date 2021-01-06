package com.saregama.mvvmmusicapp.util

import android.content.Context
import com.saregama.mvvmmusicapp.App
import com.saregama.mvvmmusicapp.di.AppComponent

object AppInjection {
    fun of(context: Context?): AppComponent {
        return (context as App).applicationInjector() as AppComponent
    }
}
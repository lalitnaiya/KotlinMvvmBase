package com.saregama.mvvmmusicapp

import android.content.Context
import androidx.multidex.MultiDex
import com.saregama.mvvmmusicapp.di.DaggerAppComponent
import com.saregama.mvvmmusicapp.di.DatabaseModule
import com.saregama.mvvmmusicapp.di.NetworkModule
import com.saregama.mvvmmusicapp.util.PreferenceUtils
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

open class App : DaggerApplication() {

    lateinit var androidInjector: AndroidInjector<out DaggerApplication>

//    private val instance: App? = null
//
//    @Synchronized
//    open fun getInstance(): App? {
//        return instance
//    }


    @get:Synchronized
    val prefs: PreferenceUtils by lazy {
        PreferenceUtils(this)
    }

    companion object {
        private var instance: App? = null

        fun getContext(): App {
            return instance!!
        }


    }
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
        androidInjector = DaggerAppComponent.builder()
                .application(this)
                .database(databaseModule())
                .network(networkModule())
                .build()
    }

    override fun onCreate() {
        super.onCreate()
//        initTimber()
//        initThreeTenABP()
    }

    public override fun applicationInjector(): AndroidInjector<out DaggerApplication> = androidInjector

    protected open fun databaseModule(): DatabaseModule = DatabaseModule()

    protected open fun networkModule(): NetworkModule = NetworkModule()

//
//    protected open fun initTimber() = Timber.plant()
//
//    protected open fun initThreeTenABP() = AndroidThreeTen.init(this)
}
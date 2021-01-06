package com.saregama.mvvmmusicapp

import android.util.Log
import android.view.Window
import android.view.WindowManager
import com.google.gson.Gson
import com.orhanobut.logger.Logger
import com.saregama.mvvmmusicapp.data.local.ApodOfConfig
import com.saregama.mvvmmusicapp.data.remote.ConfigService
import com.saregama.mvvmmusicapp.databinding.ActivitySplashBinding
import com.saregama.mvvmmusicapp.di.NetworkModule
import com.saregama.mvvmmusicapp.ui.component.activity.BaseActivity
import io.reactivex.Flowable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SplashActivity : BaseActivity<SplashViewModel, ActivitySplashBinding>() {

    override val layout: Int = R.layout.activity_splash

    override val viewModel: Class<SplashViewModel>? = SplashViewModel::class.java

    override fun setView() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

//        Log.e("Splash","Splash Screen" +mViewModel!!.config)

    }


}
package com.saregama.mvvmmusicapp

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.saregama.mvvmmusicapp.databinding.ActivityMainBinding
import com.saregama.mvvmmusicapp.ui.component.activity.BaseActivity
import com.saregama.mvvmmusicapp.ui.MainViewModel

class MainActivity : BaseActivity<SplashViewModel, ActivityMainBinding>() {

    override val layout: Int = R.layout.activity_main
    override val viewModel: Class<SplashViewModel>? = SplashViewModel::class.java
//    override val viewBinding: ActivityMainBinding = ActivityMainBinding.i

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun setView() {
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        mBinding!!.navView.setupWithNavController(navController)

        mViewModel!!.loadDataRx()
    }


}
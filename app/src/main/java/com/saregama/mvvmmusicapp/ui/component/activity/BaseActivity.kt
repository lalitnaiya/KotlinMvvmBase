package com.saregama.mvvmmusicapp.ui.component.activity

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.annotation.Nullable
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject


abstract class BaseActivity<V : ViewModel?, B : ViewDataBinding?> :
    DaggerAppCompatActivity() {

    protected var mViewModel: V? = null
    protected var mBinding: B? = null

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @get:LayoutRes
    protected abstract val layout: Int
    protected abstract val viewModel: Class<V>?
    protected abstract fun setView()
//    abstract val viewBinding: B


    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDependencyInjection()
        init()
    }

    protected fun init() {
        mBinding = DataBindingUtil.setContentView(this, layout)
        mViewModel = ViewModelProvider(this, viewModelFactory).get(viewModel!!)
    }

    private fun performDependencyInjection() {
        AndroidInjection.inject(this)
    }


}
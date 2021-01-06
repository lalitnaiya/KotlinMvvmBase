package com.saregama.mvvmmusicapp.ui.component.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


abstract class BaseFragment<V : ViewModel?, B : ViewDataBinding?> :
    Fragment() {

    protected var mViewModel: V? = null
    protected var mBinding: B? = null

    @get:LayoutRes
    protected abstract val layout: Int

    protected abstract val viewModel: Class<V>?
    protected abstract val viewBinding: B

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
        init()
    }


    protected fun init() {
        mBinding = DataBindingUtil.setContentView(requireActivity(), layout)
        mViewModel = ViewModelProvider(this).get(viewModel!!)
    }
}
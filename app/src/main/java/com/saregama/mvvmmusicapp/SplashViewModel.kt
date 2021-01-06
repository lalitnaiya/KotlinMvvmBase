package com.saregama.mvvmmusicapp


import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.saregama.mvvmmusicapp.data.local.ApodOfConfig
import com.saregama.mvvmmusicapp.data.remote.ConfigService
import com.saregama.mvvmmusicapp.data.repository.Config
import com.saregama.mvvmmusicapp.di.NetworkModule
import com.saregama.mvvmmusicapp.di.Qualifiers.MODEL_MUSIC
import com.saregama.mvvmmusicapp.ui.component.baseviewmodel.BaseViewModel
import com.saregama.mvvmmusicapp.util.Result
import com.saregama.mvvmmusicapp.util.defaultErrorHandler
import com.saregama.mvvmmusicapp.util.ext.toLiveData
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.flow.observeOn
import kotlinx.coroutines.flow.subscribeOn
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val configRepository: Config
) : BaseViewModel(), LifecycleObserver {

    var dataLoading: MutableLiveData<Boolean> = MutableLiveData()

    fun loadDataRx() {
        dataLoading.value = true
        addDisposable(configRepository.getInfo("c_music")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doFinally { dataLoading.value = false }
            .subscribe({ response ->
                Result.success(response)
            }, {  })
        )
    }

//    val config: LiveData<Result<ApodOfConfig>> by lazy {
//
//        configRepository.getInfo(MODEL_MUSIC)
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .map { Result.success(it) }
//            .doOnError(defaultErrorHandler())
//            .onErrorReturn { Result.failure(it) }
//            .startWith(Result.loading())
//            .toLiveData()
//    }
}
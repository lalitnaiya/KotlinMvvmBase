package com.saregama.mvvmmusicapp.di

import com.saregama.mvvmmusicapp.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBuilder::class,
        AppModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: App): Builder

        fun database(database: DatabaseModule): Builder

        fun network(network: NetworkModule): Builder

        fun build(): AppComponent

    }

    override fun inject(app: App)

//    fun inject(glideModule: GlideModule)
}
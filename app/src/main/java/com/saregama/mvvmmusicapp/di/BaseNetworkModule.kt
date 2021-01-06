package com.saregama.mvvmmusicapp.di

import com.saregama.mvvmmusicapp.App
import com.saregama.mvvmmusicapp.BuildConfig
import com.saregama.mvvmmusicapp.PostMusicInterceptor
import com.saregama.mvvmmusicapp.data.remote.ConfigService
import com.saregama.mvvmmusicapp.util.ApplicationJsonAdapterFactory
import com.saregama.mvvmmusicapp.util.InstantAdapter
import com.saregama.mvvmmusicapp.util.Memory
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
class BaseNetworkModule {

    fun buildOkHttpClient(app: App): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.HEADERS
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val builder = OkHttpClient.Builder()
        builder.addInterceptor(interceptor)
            .connectTimeout(10L, TimeUnit.SECONDS)
            .writeTimeout(10L, TimeUnit.SECONDS)
            .readTimeout(30L, TimeUnit.SECONDS)
            .cache(
                Cache(
                    File(app.cacheDir, "OkCache"),
                    Memory.calcCacheSize(app, .25f)
                )
            )
            .addInterceptor(PostMusicInterceptor())
            .authenticator(PostMusicInterceptor())
        return builder.build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(app: App): OkHttpClient = buildOkHttpClient(app)

    @Singleton
    @Provides
    fun provideMoshi() = Moshi.Builder()
        .add(ApplicationJsonAdapterFactory.INSTANCE)
        .add(InstantAdapter.INSTANCE)
        .build()

    @Provides
    @Singleton
    @Named(Qualifiers.MUSIC)
    fun provideRetrofitForNasa(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit =
        Retrofit.Builder()
            .baseUrl("${BuildConfig.HTTPS}://${BuildConfig.MUSIC_ENDPOINT}/")
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    @Provides
    @Singleton
    fun providePlanetService(@Named(Qualifiers.MUSIC) retrofit: Retrofit): ConfigService =
        retrofit.create(ConfigService::class.java)
}
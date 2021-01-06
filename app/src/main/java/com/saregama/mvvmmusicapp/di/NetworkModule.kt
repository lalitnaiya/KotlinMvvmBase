package com.saregama.mvvmmusicapp.di

import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.saregama.mvvmmusicapp.App
import com.saregama.mvvmmusicapp.BuildConfig.HTTPS
import com.saregama.mvvmmusicapp.BuildConfig.MUSIC_ENDPOINT
import com.saregama.mvvmmusicapp.data.remote.ConfigService
import com.saregama.mvvmmusicapp.di.Qualifiers.MUSIC
import com.saregama.mvvmmusicapp.di.Qualifiers.header_device_type
import com.saregama.mvvmmusicapp.di.Qualifiers.header_device_type_value
import com.saregama.mvvmmusicapp.di.Qualifiers.header_user_id
import com.saregama.mvvmmusicapp.util.*
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton


@Module
open class NetworkModule {


    @Singleton
    @Provides
    fun provideLogger(): HttpLoggingInterceptor =
         HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BASIC)


    @Singleton
    @Provides
    fun provideHeader(): Interceptor =
        Interceptor { chain ->
            val newRequest = chain.request()
                .newBuilder()
                .header(header_device_type, header_device_type_value)
                .header(Qualifiers.header_device_id, Utils.encode(Factory.getDeviceId()))
                .header(Qualifiers.header_auth_key, Factory.getAuthKey())
                .header(Qualifiers.header_playon, Qualifiers.header_music)
                .header("name", Utils.encode(Factory.getDeviceName()))
                .header("os_v", Utils.encode(Factory.getOSVersion()))
                .header("app_v", Utils.encode(Factory.getAppVersion()))
                .build()
            chain.proceed(newRequest)
        }


    @Singleton
    @Provides
    fun provideOkHttpClient(app: App, httpLoggingInterceptor: HttpLoggingInterceptor, httpHeaderInterceptor: Interceptor ): OkHttpClient =

        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .connectTimeout(10L, TimeUnit.SECONDS)
            .writeTimeout(10L, TimeUnit.SECONDS)
            .readTimeout(30L, TimeUnit.SECONDS)
            .cache(Cache(File(app.cacheDir, "OkCache"),
                Memory.calcCacheSize(app, .25f)))
            .addInterceptor(httpHeaderInterceptor)
            .build()


//
//    @Provides
//    @Singleton
//    fun provideOkHttpClient(app: App): OkHttpClient = buildOkHttpClient(app)


    @Singleton
    @Provides
    fun provideMoshi() = Moshi.Builder()
        .add(ApplicationJsonAdapterFactory.INSTANCE)
        .add(InstantAdapter.INSTANCE)
        .build()

    @Provides
    @Singleton
    fun providesConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }


    @Provides
    @Singleton
    @Named(MUSIC)
    fun provideRetrofitForNasa(gsonConverterFactory: GsonConverterFactory,okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl("$HTTPS://$MUSIC_ENDPOINT/")
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()

    @Provides
    @Singleton
    fun providePlanetService(retrofit: Retrofit): ConfigService =
        retrofit.create(ConfigService::class.java)
}
package com.movieslist.di.modules.dataModule

import com.data.client.api.MovieApi
import com.data.client.api.UserApi
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.movieslist.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    internal fun provideGson(): Gson = GsonBuilder()
        .serializeNulls()
        .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
        .create()

    @Singleton
    @Provides
    internal fun provideLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            if (BuildConfig.DEBUG) {
                this.level = HttpLoggingInterceptor.Level.BODY
            } else {
                this.level = HttpLoggingInterceptor.Level.NONE
            }
        }

    @Singleton
    @Provides
    internal fun provideHeaderInterceptor(): Interceptor =
        Interceptor { chain ->
            chain.run {
                proceed(
                    request()
                        .newBuilder()
                        .addHeader("accept", "application/json")
                        .addHeader("content-type", "application/json")
                        .build()
                )
            }
        }

    @Singleton
    @Provides
    internal fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        headerInterceptor: Interceptor
    ): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(headerInterceptor)
            .readTimeout(40, TimeUnit.SECONDS)
            .connectTimeout(40, TimeUnit.SECONDS)
            .build()

    @Singleton
    @Provides
    internal fun provideRetrofitInterface(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    internal fun provideReportApiRx(retrofit: Retrofit): MovieApi {
        return retrofit.create(MovieApi::class.java)
    }

    @Singleton
    @Provides
    internal fun provideUserApiRx(retrofit: Retrofit): UserApi {
        return retrofit.create(UserApi::class.java)
    }
}

package com.elhady.mega.di

import com.elhady.mega.Constant.Companion.BASE_URL
import com.elhady.mega.data.remote.RequestInterceptor
import com.elhady.mega.data.remote.client.JobsClient
import com.elhady.mega.data.remote.service.JobService
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(RequestInterceptor())
            .connectTimeout(timeoutConnect.toLong(), TimeUnit.SECONDS)
            .readTimeout(timeoutRead.toLong(), TimeUnit.SECONDS)
            .build()
    }

    single {
        Retrofit.Builder()
            .client(get<OkHttpClient>())
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single { get<Retrofit>().create(JobService::class.java) }

    single { JobsClient(get()) }
}
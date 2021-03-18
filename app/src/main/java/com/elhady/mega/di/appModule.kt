package com.elhady.mega.di

import com.elhady.mega.data.api.ApiHelper
import com.elhady.mega.data.api.ApiHelperImpl
import com.elhady.mega.data.api.ApiService
import com.elhady.mega.utils.BASE_URL
import com.elhady.mega.utils.timeoutConnect
import com.elhady.mega.utils.timeoutRead
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val appModule = module {

    single {
        OkHttpClient.Builder()
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

    single {
        get<Retrofit>().create(ApiService::class.java)
    }

    single<ApiHelper> {
        return@single ApiHelperImpl(get())
    }

}
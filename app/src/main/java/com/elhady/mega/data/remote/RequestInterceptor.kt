package com.elhady.mega.data.remote

import okhttp3.Interceptor
import okhttp3.Response


class RequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        val request = originalRequest.newBuilder()
            .header(contentType, contentTypeValue)
            .method(originalRequest.method, originalRequest.body)
            .build()

        return chain.proceed(request)
    }
}
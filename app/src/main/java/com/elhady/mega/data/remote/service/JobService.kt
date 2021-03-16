package com.elhady.mega.data.remote.service

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface JobService {
    @GET("")
    fun fetchAPIData(@Path("description") api: String): Call<JobService>
}
package com.elhady.mega.data.api

import com.elhady.mega.data.model.Jobs
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("positions.json")
    suspend fun getJobs(@Query("description") api : String): List<Jobs>
}
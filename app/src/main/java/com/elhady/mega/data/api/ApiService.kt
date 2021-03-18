package com.elhady.mega.data.api

import com.elhady.mega.data.model.Jobs
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by islam elhady on 03/16/2021.
 */
interface ApiService {
    @GET("positions.json")
    suspend fun getJobs(@Query("description") api : String): Response<List<Jobs>>
}
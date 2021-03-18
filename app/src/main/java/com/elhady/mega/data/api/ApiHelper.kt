package com.elhady.mega.data.api

import com.elhady.mega.data.model.Jobs
import retrofit2.Response

interface ApiHelper {

    suspend fun getJobs(): Response<List<Jobs>>
}
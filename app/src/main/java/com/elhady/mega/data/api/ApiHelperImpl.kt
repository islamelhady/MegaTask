package com.elhady.mega.data.api

import com.elhady.mega.data.model.Jobs
import retrofit2.Response

class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {

    override suspend fun getJobs(): Response<List<Jobs>> = apiService.getJobs("api")

}
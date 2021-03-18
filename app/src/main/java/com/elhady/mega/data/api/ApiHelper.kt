package com.elhady.mega.data.api

import com.elhady.mega.data.model.Jobs
import retrofit2.Response

/**
 * Created by islam elhady on 03/16/2021.
 */
interface ApiHelper {

    suspend fun getJobs(): Response<List<Jobs>>
}
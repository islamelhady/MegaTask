package com.elhady.mega.data.repository

import com.elhady.mega.data.api.ApiHelper

/**
 * Created by islam elhady on 03/16/2021.
 */
class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getJobs() = apiHelper.getJobs()
}
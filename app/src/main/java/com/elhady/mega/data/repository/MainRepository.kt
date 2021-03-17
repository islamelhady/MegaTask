package com.elhady.mega.data.repository

import com.elhady.mega.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getJobs() = apiHelper.getJobs()
}
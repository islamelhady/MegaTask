package com.elhady.mega.data.api

class ApiHelper(private val apiService: ApiService) {

    suspend fun getJobs() = apiService.getJobs("api")
}
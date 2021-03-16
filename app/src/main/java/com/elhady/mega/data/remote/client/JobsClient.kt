package com.elhady.mega.data.remote.client

import com.elhady.mega.data.dto.JobsResponse
import com.elhady.mega.data.remote.ApiResponse
import com.elhady.mega.data.remote.service.JobService
import com.elhady.mega.data.remote.transform


class JobsClient(private val service: JobService) {

    fun fetchJobsList(onResult: (response: ApiResponse<JobsResponse>) -> Unit) {
        this.service.fetchAPIData().transform(onResult)
    }
}
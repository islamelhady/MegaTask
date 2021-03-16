package com.elhady.mega.data.remote.repository

import androidx.lifecycle.MutableLiveData
import com.elhady.mega.data.dto.Jobs
import com.elhady.mega.data.remote.ApiResponse
import com.elhady.mega.data.remote.client.JobsClient
import com.elhady.mega.data.remote.message
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class JobsRepository constructor(
    private val jobsClient: JobsClient,
) {

    suspend fun loadJobsList(error: (String) -> Unit) =
        withContext(Dispatchers.IO) {
            val liveData = MutableLiveData<List<Jobs>>()
            var jobs = emptyList<Jobs>()
            jobsClient.fetchJobsList { response ->
                when (response) {
                    is ApiResponse.Success -> {
                        response.data?.let { data ->
                            jobs = data.jobs
                            liveData.postValue(jobs)
                        }
                    }
                    is ApiResponse.Failure.Error -> {
                        error(response.message())
                        liveData.postValue(jobs)
                    }
                    is ApiResponse.Failure.Exception -> {
                        error(response.message())
                        liveData.postValue(jobs)
                    }
                }
            }
            liveData.apply { postValue(jobs) }
        }

}
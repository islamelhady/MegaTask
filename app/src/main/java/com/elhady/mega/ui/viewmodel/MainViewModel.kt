package com.elhady.mega.ui.viewmodel

import android.os.Bundle
import androidx.lifecycle.*
import com.elhady.mega.data.model.Jobs
import com.elhady.mega.data.repository.MainRepository
import com.elhady.mega.utils.NetworkHelper
import com.elhady.mega.utils.Resource
import kotlinx.coroutines.launch

/**
 * Created by islam elhady on 03/16/2021.
 */
class MainViewModel(
    private val mainRepository: MainRepository, private val networkHelper: NetworkHelper
) : ViewModel() {


    private val _jobs = MutableLiveData<Resource<List<Jobs>>>()
    val jobs: LiveData<Resource<List<Jobs>>>
        get() = _jobs

    init {
        fetchJobs()
    }

    private fun fetchJobs() {
        viewModelScope.launch {
            _jobs.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
                mainRepository.getJobs().let {
                    if (it.isSuccessful) {
                        _jobs.postValue(Resource.success(it.body()))
                    } else _jobs.postValue(Resource.error(it.errorBody().toString(), null))
                }
            } else _jobs.postValue(Resource.error("No internet connection", null))
        }
    }

    companion object {
        private const val JobsKey = "Jobs"
        fun createArguments(jobs: Jobs): Bundle {
            val bundle = Bundle()
            bundle.putParcelable(JobsKey, jobs)
            return bundle
        }
    }
}


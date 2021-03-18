package com.elhady.mega.ui.viewmodel

import android.os.Bundle
import androidx.lifecycle.*
import com.elhady.mega.data.model.Jobs
import com.elhady.mega.data.repository.MainRepository
import com.elhady.mega.utils.Resource
import kotlinx.coroutines.launch


class MainViewModel(
    private val mainRepository: MainRepository
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
                mainRepository.getJobs().let {
                    if (it.isSuccessful) {
                        _jobs.postValue(Resource.success(it.body()))
                    } else _jobs.postValue(Resource.error(it.errorBody().toString(), null))
                }
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


package com.elhady.mega.ui.main.viewmodel

import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.elhady.mega.data.model.Jobs
import com.elhady.mega.data.repository.MainRepository
import com.elhady.mega.utils.Resource
import kotlinx.coroutines.Dispatchers


class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    fun getUsers() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getJobs()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
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


package com.elhady.mega.ui.component.jobs

import android.os.Bundle
import androidx.lifecycle.LiveData
import com.elhady.mega.data.dto.Jobs
import com.elhady.mega.data.remote.repository.JobsRepository
import com.elhady.mega.ui.base.LiveCoroutinesViewModel


class JobsListViewModel constructor(
    private val jobsRepository: JobsRepository
) : LiveCoroutinesViewModel() {

    var jobsListLiveData: LiveData<List<Jobs>> = launchOnViewModelScope {
        this.jobsRepository.loadJobsList {}
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
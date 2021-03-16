package com.elhady.mega.ui.component.jobs

import android.os.Bundle
import android.view.*
import androidx.navigation.fragment.findNavController
import com.elhady.mega.R
import com.elhady.mega.data.dto.Jobs
import com.elhady.mega.databinding.FragmentJobsListBinding
import com.elhady.mega.ui.base.DataBindingFragment
import com.elhady.mega.ui.base.bindings.bindAdapterJobsList
import com.elhady.mega.ui.component.jobs.adapter.JobsAdapter
import com.elhady.mega.ui.component.jobs.viewholder.JobsViewholder
import kotlinx.android.synthetic.main.fragment_jobs_list.*
import org.koin.android.viewmodel.ext.android.viewModel


class JobsListFragment : DataBindingFragment(), JobsViewholder.Delegate {

    private val viewModel: JobsListViewModel by viewModel()
    private lateinit var binding: FragmentJobsListBinding
    private val adapterJobsList = JobsAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = binding(
            inflater, R.layout.fragment_jobs_list, container
        )
        return binding.apply {
            viewModel = this@JobsListFragment.viewModel
            lifecycleOwner = this@JobsListFragment
            adapter = JobsAdapter(this@JobsListFragment)
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showJobs()
    }

    private fun showJobs() {
        rvJobs.removeAllViewsInLayout()
        viewModel.jobsListLiveData.value?.let {
            adapterJobsList.addJobsList(it)
        }
        bindAdapterJobsList(rvJobs, viewModel.jobsListLiveData.value)
    }

    override fun onItemClick(view: View, jobs: Jobs) {
        findNavController().navigate(
            R.id.actionJobsDetails,
            JobsListViewModel.createArguments(jobs)
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.unbind()
    }
}
package com.elhady.mega.ui.view.jobs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.elhady.mega.R
import com.elhady.mega.data.model.Jobs
import com.elhady.mega.databinding.FragmentJobsListBinding
import com.elhady.mega.ui.adapter.MainAdapter
import com.elhady.mega.utils.Status
import com.elhady.mega.ui.viewmodel.MainViewModel
import com.elhady.mega.ui.viewmodel.MainViewModel.Companion.createArguments
import kotlinx.android.synthetic.main.fragment_jobs_list.*
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by islam elhady on 03/16/2021.
 */
class JobsListFragment : Fragment(), MainAdapter.OnJobItemClickListener {

    private lateinit var binding: FragmentJobsListBinding
    private val mainViewModel: MainViewModel by viewModel()
    private lateinit var adapter: MainAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentJobsListBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        setupUI()
    }

    private fun setupObservers() {
        mainViewModel.jobs.observe(viewLifecycleOwner, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        recyclerView.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        resource.data?.let { jobs -> retrieveList(jobs) }
                    }
                    Status.ERROR -> {
                        recyclerView.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        Toast.makeText(activity, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        progressBar.visibility = View.VISIBLE
                        recyclerView.visibility = View.GONE
                    }
                }
            }
        })
    }

    private fun setupUI() {
        recyclerView.layoutManager = LinearLayoutManager(activity)
        adapter = MainAdapter(arrayListOf(), this)
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = adapter
    }

    private fun retrieveList(jobs: List<Jobs>) {
        adapter.apply {
            addJobsList(jobs)
            notifyDataSetChanged()
        }
    }

    override fun onItemClick(jobs: Jobs, position: Int) {
        findNavController().navigate(R.id.jobsDetailsFragment, createArguments(jobs))

    }

}
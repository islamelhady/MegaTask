package com.elhady.mega.ui.main.view.jobs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.elhady.mega.R
import com.elhady.mega.data.api.ApiHelper
import com.elhady.mega.data.api.RetrofitBuilder
import com.elhady.mega.data.model.Jobs
import com.elhady.mega.ui.base.ViewModelFactory
import com.elhady.mega.ui.main.adapter.MainAdapter
import com.elhady.mega.utils.Status
import com.elhady.mega.ui.main.viewmodel.MainViewModel
import com.elhady.mega.ui.main.viewmodel.MainViewModel.Companion.createArguments
import kotlinx.android.synthetic.main.fragment_jobs_list.*


class JobsListFragment : Fragment() , MainAdapter.OnJobItemClickListener{

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: MainAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_jobs_list, container, false)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()
        setupObservers()
        setupUI()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        ).get(MainViewModel::class.java)
    }

    private fun setupObservers() {
        viewModel.getUsers().observe(viewLifecycleOwner, Observer {
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
        adapter = MainAdapter(arrayListOf(),this)
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
            addUsers(jobs)
            notifyDataSetChanged()
        }
    }

    override fun onItemClick(jobs: Jobs, position: Int) {
        Toast.makeText(activity, jobs.title, Toast.LENGTH_LONG).show()
        findNavController().navigate(R.id.jobsDetailsFragment,createArguments(jobs))

    }

}
package com.elhady.mega.ui.component.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.elhady.mega.R
import com.elhady.mega.data.dto.Jobs
import com.elhady.mega.databinding.FragmentJobsDetailsBinding
import com.elhady.mega.ui.base.DataBindingFragment
import kotlinx.android.synthetic.main.fragment_jobs_details.*


class JobsDetailsFragment : DataBindingFragment() {

    private lateinit var binding: FragmentJobsDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = binding(
            inflater, R.layout.fragment_jobs_details, container
        )
        return binding.apply {
            jobs = (requireArguments().get(getString(R.string.jobs_key))) as Jobs
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar(toolbar, activity as AppCompatActivity)
    }

    private fun initToolbar(toolbar: Toolbar, activity: AppCompatActivity) {
        activity.setSupportActionBar(toolbar)
        activity.supportActionBar?.title = ""
        activity.supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    // clear views references to fix memory leaks
    override fun onDestroyView() {
        super.onDestroyView()
        binding.unbind()
    }
}
package com.elhady.mega.ui.view.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.elhady.mega.R
import com.elhady.mega.data.model.Jobs
import com.elhady.mega.databinding.FragmentJobsDetailsBinding

class JobsDetailsFragment : Fragment() {

    private lateinit var binding: FragmentJobsDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentJobsDetailsBinding.inflate(inflater, container, false)
        return binding.apply {
            jobs = (requireArguments().get(getString(R.string.jobs_key))) as Jobs
        }.root
    }
}
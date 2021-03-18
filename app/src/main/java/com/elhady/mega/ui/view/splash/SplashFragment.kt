package com.elhady.mega.ui.view.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.elhady.mega.R
import kotlinx.android.synthetic.main.fragment_splash.*
/**
 * Created by islam elhady on 03/16/2021.
 */
class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        start.setOnClickListener {
            findNavController().navigate(R.id.jobsListFragment)
        }
    }
}
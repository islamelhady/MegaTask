package com.elhady.mega.ui.base.bindings

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.elhady.mega.data.dto.Jobs
import com.elhady.mega.ui.component.jobs.adapter.JobsAdapter
import com.skydoves.baserecyclerviewadapter.BaseAdapter

@BindingAdapter("adapter")
fun bindAdapter(view: RecyclerView, baseAdapter: BaseAdapter) {
    view.adapter = baseAdapter
}

@BindingAdapter("adapterJobsList")
fun bindAdapterJobsList(view: RecyclerView, jobs: List<Jobs>?) {
    if (!jobs.isNullOrEmpty()) {
        val adapter = view.adapter as? JobsAdapter
        adapter?.addJobsList(jobs)
    }
}
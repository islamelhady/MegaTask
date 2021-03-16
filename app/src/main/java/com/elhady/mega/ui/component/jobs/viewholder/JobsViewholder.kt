package com.elhady.mega.ui.component.jobs.viewholder

import android.view.View
import androidx.core.view.ViewCompat
import com.elhady.mega.data.dto.Jobs
import com.elhady.mega.ui.base.bindings
import com.skydoves.baserecyclerviewadapter.BaseViewHolder


class JobsViewholder(
    view: View,
    private val delegate: Delegate
) : BaseViewHolder(view) {

    interface Delegate {
        fun onItemClick(view: View, jobs: Jobs)
    }

    private lateinit var jobs: Jobs
    private val binding by bindings<ItemJobsBinding>(view)

    override fun bindData(data: Any) {
        if (data is Jobs) {
            jobs = data
            binding.apply {
                ViewCompat.setTransitionName(binding.itemJobsContainer, data.name)
                jobs = data
                executePendingBindings()
            }
        }
    }

    override fun onClick(v: View?) = delegate.onItemClick(binding.itemJobsContainer, jobs)

    override fun onLongClick(v: View?): Boolean = true
}

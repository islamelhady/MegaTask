package com.elhady.mega.ui.component.jobs.adapter

import android.view.View
import com.elhady.mega.data.dto.Jobs
import com.elhady.mega.ui.component.jobs.viewholder.JobsViewholder
import com.skydoves.baserecyclerviewadapter.BaseAdapter
import com.skydoves.baserecyclerviewadapter.SectionRow


class JobsAdapter(
    private val delegate: JobsViewholder.Delegate
) : BaseAdapter() {

    init {
        addSection(ArrayList<Jobs>())
    }

    fun addJobsList(jobs: List<Jobs>) {
        val section = sections()[0]
        section.addAll(jobs)
        notifyItemRangeInserted(section.size - jobs.size + 1, jobs.size)
    }

    override fun layout(sectionRow: SectionRow) = item

    override fun viewHolder(layout: Int, view: View) = JobsViewholder(view, delegate)
}
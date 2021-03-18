package com.elhady.mega.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.elhady.mega.data.model.Jobs
import com.elhady.mega.databinding.ItemJobsBinding

/**
 * Created by islam elhady on 03/16/2021.
 */
class MainAdapter(
    private val jobs: ArrayList<Jobs>,
    private val clickListener: OnJobItemClickListener
) :
    RecyclerView.Adapter<MainAdapter.JobsViewHolder>() {

    class JobsViewHolder(
        private val binding: ItemJobsBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Jobs, action: OnJobItemClickListener) {

                binding.apply {
                    job = item
                    executePendingBindings()
                }

            itemView.setOnClickListener {
                action.onItemClick(item, adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobsViewHolder {
        return JobsViewHolder(
            ItemJobsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = jobs.size

    override fun onBindViewHolder(holder: JobsViewHolder, position: Int) {
        holder.bind(jobs[position], clickListener)
    }

    fun addJobsList(jobs: List<Jobs>) {
        this.jobs.apply {
            clear()
            addAll(jobs)
        }
    }

    interface OnJobItemClickListener {
        fun onItemClick(jobs: Jobs, position: Int)
    }
}
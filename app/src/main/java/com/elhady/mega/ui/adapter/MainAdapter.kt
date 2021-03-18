package com.elhady.mega.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.elhady.mega.R
import com.elhady.mega.data.model.Jobs
import kotlinx.android.synthetic.main.item_jobs.view.*

class MainAdapter(private val jobs: ArrayList<Jobs>, private val clickListener: OnJobItemClickListener) :
    RecyclerView.Adapter<MainAdapter.DataViewHolder>() {
    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(jobs: Jobs, action: OnJobItemClickListener) {
            itemView.apply {
                job_title.text = jobs.title
                company_name.text = jobs.company
            }
            itemView.setOnClickListener {
                action.onItemClick(jobs, adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_jobs, parent, false)
        )

    override fun getItemCount(): Int = jobs.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(jobs[position], clickListener)
    }

    fun addUsers(jobs: List<Jobs>) {
        this.jobs.apply {
            clear()
            addAll(jobs)
        }
    }

    interface OnJobItemClickListener {
        fun onItemClick(jobs: Jobs, position: Int)
    }
}
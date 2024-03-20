package com.anubhav.mytasks.ui.recyclerviewadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anubhav.mytasks.databinding.ListItemLayoutBinding
import com.anubhav.mytasks.models.TaskItem

class RecyclerViewAdapter(var taskList: List<TaskItem>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ListItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(taskItem: TaskItem) {
            binding.task = taskItem
            binding.executePendingBindings()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListItemLayoutBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //this is where we provide individual item data in the list to be bound to the layout file
        val item = taskList[position]
        holder.bind(item)
    }


}
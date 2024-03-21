package com.anubhav.mytasks.ui.recyclerviewadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.anubhav.mytasks.R
import com.anubhav.mytasks.models.TaskItem
import com.anubhav.mytasks.ui.interfaces.OnTaskContainerClicked
import com.google.android.material.chip.Chip
import com.google.android.material.textview.MaterialTextView

class RecyclerViewAdapter(
    var taskList: List<TaskItem>,
    private val onTaskContainerClicked: OnTaskContainerClicked
) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val container = itemView.findViewById<LinearLayout>(R.id.taskContainerLayout)
        val taskNameTextView = itemView.findViewById<MaterialTextView>(R.id.taskName)
        val taskPriorityTextView = itemView.findViewById<Chip>(R.id.taskPriority)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_layout, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Bind data to ViewHolder
        val taskItem = taskList[position]
        holder.taskNameTextView.text = taskItem.taskName
        holder.container.setOnClickListener {
            onTaskContainerClicked.onItemClick(taskItem)
        }
        val priorityInIntFormat = taskItem.priority
        val priorityInStringFormat = when (priorityInIntFormat) {
            1 -> "High"
            2 -> "Medium"
            3 -> "Low"

            else -> {
                " "
            }
        }
        holder.taskPriorityTextView.text = priorityInStringFormat
    }

    override fun getItemCount(): Int {
        // return the size of task list
        return taskList.size
    }

}
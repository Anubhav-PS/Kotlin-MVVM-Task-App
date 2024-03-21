package com.anubhav.mytasks.ui.interfaces

import com.anubhav.mytasks.models.TaskItem

interface OnTaskContainerClicked {

    fun onItemClick(taskItem: TaskItem)

}
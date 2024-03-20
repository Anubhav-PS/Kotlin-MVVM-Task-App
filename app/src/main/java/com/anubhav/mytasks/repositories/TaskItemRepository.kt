package com.anubhav.mytasks.repositories

import androidx.lifecycle.LiveData
import com.anubhav.mytasks.dao.TaskItemDao
import com.anubhav.mytasks.models.TaskItem

class TaskItemRepository(
    private val taskItemDao: TaskItemDao
) {

    val allTasks: LiveData<List<TaskItem>> = taskItemDao.getAllTasks()

    suspend fun insertTaskItem(taskItem: TaskItem){
        taskItemDao.insertTaskItem(taskItem)
    }

    suspend fun getAllTaskItemInAscendingOrder(): List<TaskItem> {
        return taskItemDao.getAllTasksInAscending()
    }

    suspend fun deleteAllTaskItem() {
        taskItemDao.deleteAllTasks()
    }

}
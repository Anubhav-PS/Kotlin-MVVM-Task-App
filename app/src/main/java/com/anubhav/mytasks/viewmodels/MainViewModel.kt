package com.anubhav.mytasks.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.anubhav.mytasks.models.TaskItem
import com.anubhav.mytasks.repositories.TaskItemRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val application: Application,
    private val taskItemRepository: TaskItemRepository
) : AndroidViewModel(application) {

    val allTaskItem: LiveData<List<TaskItem>> = taskItemRepository.allTasks
    private val _sortedTaskList: MutableLiveData<List<TaskItem>> = MutableLiveData()
    val sortedTaskList: LiveData<List<TaskItem>> = _sortedTaskList

    fun getAllTaskInAscendingOrder() {
        viewModelScope.launch(Dispatchers.IO) {
            val list = taskItemRepository.getAllTaskItemInAscendingOrder()
            _sortedTaskList.postValue(list)
        }
    }

    fun insertTaskItem(taskItem: TaskItem) {
        viewModelScope.launch(Dispatchers.IO) {
            taskItemRepository.insertTaskItem(taskItem)
        }
    }

    fun deleteAllTaskItem() {
        viewModelScope.launch(Dispatchers.IO) {
            taskItemRepository.deleteAllTaskItem()
        }
    }

}

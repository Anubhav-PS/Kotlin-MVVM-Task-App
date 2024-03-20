package com.anubhav.mytasks.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.anubhav.mytasks.models.TaskItem

@Dao
interface TaskItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTaskItem(taskItem: TaskItem)

    @Query("DELETE FROM task_table ")
    suspend fun deleteAllTasks()

    @Query("SELECT * FROM task_table")
    fun getAllTasks(): LiveData<List<TaskItem>>

    @Query("SELECT * FROM task_table ORDER BY taskName ASC")
    suspend fun getAllTasksInAscending(): List<TaskItem>

}
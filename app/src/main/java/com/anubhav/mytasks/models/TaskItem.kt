package com.anubhav.mytasks.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_table")
data class TaskItem(
    val taskName: String,
    val priority: Int,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
)
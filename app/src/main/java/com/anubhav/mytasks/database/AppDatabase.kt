package com.anubhav.mytasks.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.anubhav.mytasks.dao.TaskItemDao
import com.anubhav.mytasks.models.TaskItem

@Database(
    entities = [TaskItem::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun taskItemDao(): TaskItemDao
}
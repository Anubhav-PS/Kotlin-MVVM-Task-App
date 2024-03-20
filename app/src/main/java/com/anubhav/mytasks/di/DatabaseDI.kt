package com.anubhav.mytasks.di

import android.content.Context
import androidx.room.Room
import com.anubhav.mytasks.database.AppDatabase

fun provideRoomDatabase(context: Context) =
    Room.databaseBuilder(context, AppDatabase::class.java, "MY_TASK_DATABASE")
        .allowMainThreadQueries().build()

fun provideTaskItemDao(database: AppDatabase) = database.taskItemDao()

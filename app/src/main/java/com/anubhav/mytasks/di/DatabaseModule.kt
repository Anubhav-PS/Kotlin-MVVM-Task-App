package com.anubhav.mytasks.di

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single { provideRoomDatabase(androidContext()) }
    single { provideTaskItemDao(get()) }
}
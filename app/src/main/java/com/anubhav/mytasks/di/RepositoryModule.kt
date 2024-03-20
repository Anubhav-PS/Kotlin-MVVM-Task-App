package com.anubhav.mytasks.di

import com.anubhav.mytasks.repositories.TaskItemRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory { TaskItemRepository(get()) }
}
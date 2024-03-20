package com.anubhav.mytasks.di

import app.efficientbytes.androidnow.di.viewModelModule
import org.koin.dsl.module

val appModule = module {
    includes(
        databaseModule, repositoryModule, viewModelModule
    )
}
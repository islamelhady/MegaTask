package com.elhady.mega.di

import com.elhady.mega.data.remote.repository.JobsRepository
import org.koin.dsl.module


val repositoryModule = module {
    single { JobsRepository(get(), get()) }
}
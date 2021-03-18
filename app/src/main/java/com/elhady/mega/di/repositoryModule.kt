package com.elhady.mega.di

import com.elhady.mega.data.repository.MainRepository
import org.koin.dsl.module

val repositoryModule = module {
    single {
        MainRepository(get())
    }
}
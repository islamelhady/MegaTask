package com.elhady.mega.di

import com.elhady.mega.data.repository.MainRepository
import org.koin.dsl.module

/**
 * Created by islam elhady on 03/16/2021.
 */
val repositoryModule = module {
    single {
        MainRepository(get())
    }
}
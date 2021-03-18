package com.elhady.mega.di

import com.elhady.mega.ui.viewmodel.MainViewModel
import org.koin.dsl.module

/**
 * Created by islam elhady on 03/16/2021.
 */
val viewModelModule = module {
    single {
        MainViewModel(get(), get())
    }
}
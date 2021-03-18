package com.elhady.mega.di

import com.elhady.mega.ui.viewmodel.MainViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single {
        MainViewModel(get())
    }
}
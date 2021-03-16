package com.elhady.mega.di

import com.elhady.mega.ui.component.jobs.JobsListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel { JobsListViewModel(get()) }
}
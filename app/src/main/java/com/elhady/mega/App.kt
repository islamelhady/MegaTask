package com.elhady.mega

import android.app.Application
import com.elhady.mega.di.networkModule
import com.elhady.mega.di.repositoryModule
import com.elhady.mega.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(networkModule)
            modules(viewModelModule)
            modules(repositoryModule)
            modules(persistenceModule)
        }
    }
}
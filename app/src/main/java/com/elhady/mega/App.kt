package com.elhady.mega

import android.app.Application
import com.elhady.mega.di.appModule
import com.elhady.mega.di.repositoryModule
import com.elhady.mega.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created by islam elhady on 03/16/2021.
 */
class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(appModule)
            modules(repositoryModule)
            modules(viewModelModule)
        }
    }
}
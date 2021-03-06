package com.example.apicallsample

import android.app.Application
import com.example.apicallsample.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AppControler : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@AppControler)
            modules(appModules)
        }
    }
}
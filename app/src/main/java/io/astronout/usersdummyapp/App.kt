package io.astronout.usersdummyapp

import android.app.Application
import io.astronout.usersdummyapp.di.module.appModule
import io.astronout.usersdummyapp.di.module.repoModule
import io.astronout.usersdummyapp.di.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(appModule, repoModule, viewModelModule))
        }
    }

}
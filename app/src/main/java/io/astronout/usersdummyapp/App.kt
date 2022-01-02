package io.astronout.usersdummyapp

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import io.astronout.usersdummyapp.di.module.appModule
import io.astronout.usersdummyapp.di.module.dagger2.DaggerAppComponent
import io.astronout.usersdummyapp.di.module.repoModule
import io.astronout.usersdummyapp.di.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import javax.inject.Inject

class App: Application(), HasAndroidInjector {

    override fun onCreate() {
        super.onCreate()
//        startKoin {
//            androidContext(this@App)
//            modules(listOf(appModule, repoModule, viewModelModule))
//        }
        DaggerAppComponent.create()
            .inject(this)
    }

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

}
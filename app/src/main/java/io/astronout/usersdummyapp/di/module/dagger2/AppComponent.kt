package io.astronout.usersdummyapp.di.module.dagger2

import dagger.Component
import dagger.android.AndroidInjectionModule
import io.astronout.usersdummyapp.App
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityBuilder::class,
        DaggerModule::class
    ]
)
interface AppComponent {

    fun inject(application: App)

}
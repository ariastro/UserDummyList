package io.astronout.usersdummyapp.di.module.dagger2

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.astronout.usersdummyapp.ui.detail.DetailActivity
import io.astronout.usersdummyapp.ui.main.MainActivity

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun contributeMainActivityInjector(): MainActivity

    @ContributesAndroidInjector
    abstract fun contributeDetailActivityInjector(): DetailActivity

}
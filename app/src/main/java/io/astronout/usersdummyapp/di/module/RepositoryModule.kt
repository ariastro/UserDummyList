package io.astronout.usersdummyapp.di.module

import io.astronout.usersdummyapp.data.IRepository
import io.astronout.usersdummyapp.data.RepositoryImpl
import org.koin.dsl.module

val repoModule = module {
    single<IRepository> { RepositoryImpl(get()) }
}
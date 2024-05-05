package com.example.cryptoapp.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component

@Component(modules = [
    DataModule::class,
    MapperModule::class,
    RepositoryModule::class,
    UseCaseModule::class,
    ViewModelModule::class,
    WorkerModule::class])
@ApplicationScope
interface AppComponent {

    @Component.Factory
    interface ComponentFactory {
        fun create(@BindsInstance context: Context): AppComponent
    }
}
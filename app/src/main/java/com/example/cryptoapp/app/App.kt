package com.example.cryptoapp.app

import android.app.Application
import androidx.work.Configuration
import com.example.cryptoapp.di.DaggerAppComponent
import com.example.cryptoapp.workers.WorkerFactory
import javax.inject.Inject

class App : Application(), Configuration.Provider {

    @Inject
    lateinit var workerFactory: WorkerFactory

    val component by lazy { DaggerAppComponent.factory().create(this) }
    override fun onCreate() {
        component.inject(this)
        super.onCreate()
    }

    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()
    }

}
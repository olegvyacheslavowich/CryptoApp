package com.example.cryptoapp.di

import android.content.Context
import androidx.work.WorkManager
import com.example.cryptoapp.data.database.AppDatabase
import com.example.cryptoapp.di.ApplicationScope
import com.example.cryptoapp.workers.RefreshDataWorker
import dagger.Module
import dagger.Provides

@Module
class WorkerModule {
    @Provides
    @ApplicationScope
    fun provideWorkManager(context: Context): WorkManager = WorkManager.getInstance(context)

}
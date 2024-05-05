package com.example.cryptoapp.di

import android.content.Context
import androidx.room.Room
import com.example.cryptoapp.data.database.AppDatabase
import dagger.Module
import dagger.Provides

@Module
abstract class DataModule {
    @Provides
    @ApplicationScope
    fun provideAppDatabase(context: Context): AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            AppDatabase.DB_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
}
package com.example.cryptoapp.di

import android.content.Context
import androidx.room.Room
import com.example.cryptoapp.data.database.AppDatabase
import com.example.cryptoapp.data.network.ApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Module
class DataModule {

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

    @Provides
    @ApplicationScope
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()


    @Provides
    @ApplicationScope
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create()

    companion object {
        private const val BASE_URL = "https://min-api.cryptocompare.com/data/"
    }
}
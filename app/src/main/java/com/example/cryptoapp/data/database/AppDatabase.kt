package com.example.cryptoapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CoinInfoDbModel::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    companion object {

        const val DB_NAME = "main.db"
    }

    abstract fun coinPriceInfoDao(): CoinInfoDao
}

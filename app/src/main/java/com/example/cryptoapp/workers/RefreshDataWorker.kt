package com.example.cryptoapp.workers

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkerParameters
import com.example.cryptoapp.data.database.AppDatabase
import com.example.cryptoapp.data.mapper.CoinMapper
import com.example.cryptoapp.data.network.ApiService

class RefreshDataWorker(
    context: Context,
    params: WorkerParameters,
    private val appDatabase: AppDatabase,
    private val apiService: ApiService,
    private val mapper: CoinMapper
) :
    CoroutineWorker(context, params) {

    private val coinInfoDao by lazy { appDatabase.coinPriceInfoDao() }

    override suspend fun doWork(): Result {
        val topCoins = apiService.getTopCoinsInfo(limit = 50)
        val fSyms = mapper.mapNamesListToString(topCoins)
        val jsonContainer = apiService.getFullPriceList(fSyms = fSyms)
        val coinInfoDtoList = mapper.mapJsonContainerToListCoinInfo(jsonContainer)
        val dbModelList = coinInfoDtoList.map { mapper.mapDtoToDbModel(it) }
        coinInfoDao.insertPriceList(dbModelList)
        return Result.success()
    }

    companion object {
        const val NAME = "RefreshDataWorker"

        fun makeRequest() = OneTimeWorkRequestBuilder<RefreshDataWorker>().build()
    }
}
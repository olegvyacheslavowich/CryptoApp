package com.example.cryptoapp.workers

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.ListenableWorker
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.cryptoapp.data.database.AppDatabase
import com.example.cryptoapp.data.mapper.CoinMapper
import com.example.cryptoapp.data.network.ApiService
import javax.inject.Inject

class RefreshDataWorker @Inject constructor(
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

    class WorkerFactory @Inject constructor(
        private val appDatabase: AppDatabase,
        private val apiService: ApiService,
        private val mapper: CoinMapper
    ) : ChildWorkerFactory {
        override fun create(
            context: Context,
            workerParameters: WorkerParameters
        ): ListenableWorker =
            RefreshDataWorker(context, workerParameters, appDatabase, apiService, mapper)

    }

    companion object {
        const val NAME = "RefreshDataWorker"

        fun makeRequest() = OneTimeWorkRequestBuilder<RefreshDataWorker>().build()
    }
}
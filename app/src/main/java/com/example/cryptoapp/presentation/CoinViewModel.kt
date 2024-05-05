package com.example.cryptoapp.presentation

import androidx.lifecycle.ViewModel
import com.example.cryptoapp.domain.GetCoinInfoListUseCase
import com.example.cryptoapp.domain.GetCoinInfoUseCase
import com.example.cryptoapp.domain.LoadDataUseCase
import javax.inject.Inject

class CoinViewModel : ViewModel() {

    @Inject
    lateinit var getCoinInfoListUseCase: GetCoinInfoListUseCase

    @Inject
    lateinit var getCoinInfoUseCase: GetCoinInfoUseCase

    @Inject
    lateinit var loadDataUseCase: LoadDataUseCase

    val coinInfoList = getCoinInfoListUseCase()

    fun getDetailInfo(fSym: String) = getCoinInfoUseCase(fSym)

    init {
        loadDataUseCase()
    }
}

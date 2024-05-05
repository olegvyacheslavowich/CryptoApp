package com.example.cryptoapp.di

import com.example.cryptoapp.domain.GetCoinInfoListUseCase
import com.example.cryptoapp.domain.GetCoinInfoUseCase
import com.example.cryptoapp.domain.LoadDataUseCase
import dagger.Binds
import dagger.Module

@Module
interface UseCaseModule {

    @Binds
    @ApplicationScope
    fun bindGetCoinInfoListUseCase(useCase: GetCoinInfoListUseCase): GetCoinInfoListUseCase

    @Binds
    @ApplicationScope
    fun bindGetCoinInfoUseCase(useCase: GetCoinInfoUseCase): GetCoinInfoUseCase

    @Binds
    @ApplicationScope
    fun bindLoadDataUseCase(useCase: LoadDataUseCase): LoadDataUseCase
}
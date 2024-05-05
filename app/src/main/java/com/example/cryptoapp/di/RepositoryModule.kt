package com.example.cryptoapp.di

import com.example.cryptoapp.data.repository.CoinRepositoryImpl
import com.example.cryptoapp.di.ApplicationScope
import com.example.cryptoapp.domain.CoinRepository
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {

    @Binds
    @ApplicationScope
    fun bindCoinRepository(repository: CoinRepositoryImpl): CoinRepository
}
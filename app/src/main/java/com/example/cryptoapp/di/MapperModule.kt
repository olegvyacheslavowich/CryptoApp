package com.example.cryptoapp.di

import com.example.cryptoapp.data.mapper.CoinMapper
import com.example.cryptoapp.di.ApplicationScope
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface MapperModule {

    @Binds
    @ApplicationScope
    fun bindCoinMapper(coinMapper: CoinMapper): CoinMapper

}
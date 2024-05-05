package com.example.cryptoapp.di

import android.content.Context
import com.example.cryptoapp.app.App
import com.example.cryptoapp.presentation.CoinDetailActivity
import com.example.cryptoapp.presentation.CoinDetailFragment
import com.example.cryptoapp.presentation.CoinPriceListActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Inject

@Component(
    modules = [
        DataModule::class,
        RepositoryModule::class,
        ViewModelModule::class,
        WorkerModule::class]
)
@ApplicationScope
interface AppComponent {

    fun inject(app: App)
    fun inject(activity: CoinPriceListActivity)

    fun inject(fragment: CoinDetailFragment)

    @Component.Factory
    interface ComponentFactory {
        fun create(@BindsInstance context: Context): AppComponent
    }
}
package com.example.cryptoapp.data.di

import android.content.Context
import com.example.cryptoapp.di.ApplicationScope
import dagger.BindsInstance
import dagger.Component

@Component
@ApplicationScope
interface AppComponent {

    @Component.Factory
    interface ComponentFactory {
        fun create(@BindsInstance context: Context): AppComponent
    }
}
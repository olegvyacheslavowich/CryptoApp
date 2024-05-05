package com.example.cryptoapp.app

import android.app.Application
import com.example.cryptoapp.data.di.DaggerAppComponent

class App : Application() {

    val component by lazy {
        DaggerAppComponent.factory().create(this)
    }
}
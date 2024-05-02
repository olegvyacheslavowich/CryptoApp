package com.example.cryptoapp.data.app

import android.app.Application
import com.example.cryptoapp.data.di.DaggerAppComponent

class App: Application() {

    val component = DaggerAppComponent.factory().create(this)
}
package com.marvel

import android.app.Application
import com.marvel.core.di.networkModule
import com.marvel.core.di.repositoryModule
import com.marvel.di.viewModelAppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MarvelApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MarvelApplication)
            modules(listOf(networkModule, repositoryModule, viewModelAppModule))
        }
    }

}
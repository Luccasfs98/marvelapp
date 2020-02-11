package com.marvel.di

import com.marvel.viewmodel.SplashViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelAppModule = module {
    viewModel { SplashViewModel() }
}
package br.com.marvel.featurehome.di

import br.com.marvel.featurehome.viewmodel.HomeViewModel
import br.com.marvel.featurehome.viewmodel.CharactersViewModel
import br.com.marvel.featurehome.viewmodel.SearchViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelFeatureHomeModule = module {
    viewModel { HomeViewModel() }
    viewModel { CharactersViewModel(get()) }
    viewModel { SearchViewModel() }
}
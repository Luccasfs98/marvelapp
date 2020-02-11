package com.marvel.detailcharacter.di

import com.marvel.detailcharacter.viewmodel.DetailCharacterActivityViewModel
import com.marvel.detailcharacter.viewmodel.DetailCharacterViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelFeatureDetailCharacterModule = module {
    viewModel { DetailCharacterViewModel(get()) }
    viewModel { DetailCharacterActivityViewModel(get()) }
}
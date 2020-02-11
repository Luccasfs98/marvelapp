package com.marvel.detailcharacter.viewmodel

import androidx.lifecycle.ViewModel
import br.com.marvel.core.network.repository.MarvelRepository

class DetailCharacterActivityViewModel constructor(private val marvelRepository: MarvelRepository) : ViewModel() {}
package com.marvel.detailcharacter.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.marvel.core.network.repository.MarvelRepository
import br.com.marvel.core.network.responses.BaseResponse
import com.marvel.core.network.responses.CharacterResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class DetailCharacterViewModel constructor(private val marvelRepository: MarvelRepository) : ViewModel() {

    private val TAG = DetailCharacterViewModel::class.java.simpleName

    private val viewModelJob = SupervisorJob()

    val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    val resultCharacter = MutableLiveData<CharacterResponse>()

     fun getData(id:Long?) {

        uiScope.launch {
            runCatching {
                getCharacter(id)
            }.onFailure {
                it.printStackTrace()
                Log.d(TAG, it.message)
            }
        }
    }

    /**
     * Método de busca no repositório, dos detalhes do personagem.
     * */
    private suspend fun getCharacter(id: Long?) {
        val character = marvelRepository.getCharacter(id!!)
        resultCharacter.value = character
    }

    /**
     * Cancelando o Job ao fim do ciclo de vida do ViewModel.
     * */
    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
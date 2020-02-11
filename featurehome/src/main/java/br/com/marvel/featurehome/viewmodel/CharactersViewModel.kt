package br.com.marvel.featurehome.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.marvel.core.network.repository.MarvelRepository
import com.marvel.core.network.responses.BaseResponse
import com.marvel.core.network.responses.CharacterResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class CharactersViewModel constructor(private val marvelRepository: MarvelRepository) : ViewModel() {

    private val TAG = CharactersViewModel::class.java.simpleName

    private val viewModelJob = SupervisorJob()

    val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    val resultCharacter = MutableLiveData<BaseResponse<CharacterResponse>>()

    init {
        getData()
    }

    private fun getData() {

        uiScope.launch {

            runCatching {
                getCharacteres()

            }.onFailure {
                it.printStackTrace()
                Log.d(TAG, it.message)
            }
        }
    }


    /**
     * Método de busca no repositório, dos 10 primeiros personagens.
     * */
    private suspend fun getCharacteres() {
        val characters = marvelRepository.getCharacters(1, 10)
        resultCharacter.value = characters
    }


    /**
     * Cancelando o Job ao fim do ciclo de vida do ViewModel.
     * */
    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
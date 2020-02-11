package com.marvel.detailcharacter.view

import com.marvel.common.base.BaseViewState


sealed class CharacterViewState : BaseViewState {
    /**
     * Atualizando Personagem.
     */
    object Refreshing : CharacterViewState()


    /**
     * Personagem carregado.
     */
    object Loaded : CharacterViewState()

    /**
     * Carregando Personagem.
     */
    object Loading : CharacterViewState()

    /**
     * Erro ao carregar Personagem.
     */
    object Error : CharacterViewState()

    // ============================================================================================
    //  Métodos de ajudantes públicos
    // ============================================================================================

    /**
     * Verifique se o estado atual da visualização é [Refreshing].
     *
     * @return Verdadeiro se for um estado refrescante, caso contrário, falso.
     */
    fun isRefreshing() = this is Refreshing

    /**
     * Verifique se o estado atual da visualização é [Loaded].
     *
     * @return Verdadeiro se estiver carregado, caso contrário, falso.
     */
    fun isLoaded() = this is Loaded

    /**
     * Verifique se o estado atual da visualização é [Loading].
     *
     * @return Verdadeiro se estiver carregando o estado, caso contrário, falso.
     */
    fun isLoading() = this is Loading


    /**
     * Verifique se o estado atual da visualização é [Error].
     *
     * @return Verdadeiro se for estado de erro, caso contrário, falso.
     */
    fun isError() = this is Error


}
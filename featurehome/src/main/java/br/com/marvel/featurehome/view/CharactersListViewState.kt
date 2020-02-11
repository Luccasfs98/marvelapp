package br.com.marvel.featurehome.view

import com.marvel.common.base.BaseViewState


sealed class CharactersListViewState : BaseViewState {
    /**
     * Atualizando lista de Personagens.
     */
    object Refreshing : CharactersListViewState()


    /**
     * Lista de Personagens carregados.
     */
    object Loaded : CharactersListViewState()

    /**
     * Carregando lista de Personagens.
     */
    object Loading : CharactersListViewState()

    /**
     * Carregando em adicionar mais elementos na lista de Personagens.
     */
    object AddLoading : CharactersListViewState()

    /**
     * Lista de Personagens vazios.
     */
    object Empty : CharactersListViewState()

    /**
     * Erro ao carregar a lista de Personagens.
     */
    object Error : CharactersListViewState()

    /**
     * Erro ao adicionar mais elementos à lista de Personagens.
     */
    object AddError : CharactersListViewState()

    /**
     * Não há mais elementos para adicionar à lista de Personagens.
     */
    object NoMoreElements : CharactersListViewState()


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
     * Verifique se o estado atual da visualização é [AddLoading].
     *
     * @return Verdadeiro se for adicionar estado de carregamento, caso contrário, falso.
     */
    fun isAddLoading() = this is AddLoading

    /**
     * Verifique se o estado atual da visualização é [Empty].
     *
     * @return Verdadeiro se estiver vazio, caso contrário, falso.
     */
    fun isEmpty() = this is Empty

    /**
     * Verifique se o estado atual da visualização é [Error].
     *
     * @return Verdadeiro se for estado de erro, caso contrário, falso.
     */
    fun isError() = this is Error

    /**
     * Verifique se o estado atual da visualização é [AddError].
     *
     * @return True se adicionar estado de erro, caso contrário false.
     */
    fun isAddError() = this is AddError

    /**
     * Verifique se o estado atual da visualização é [NoMoreElements].
     *
     * @return Verdadeiro se não houver mais elementos, caso contrário, falso.
     */
    fun isNoMoreElements() = this is NoMoreElements


}
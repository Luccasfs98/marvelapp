package com.marvel.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import org.koin.android.viewmodel.ext.android.getViewModel
import kotlin.reflect.KClass

abstract class BaseFragment<out VM : ViewModel>(viewModelClass: KClass<VM>) :
    Fragment() {

    lateinit var viewInflate: View

    /**
     * Substitui a variável de ligação definida
     *
     * @return variável: id
     */

    /**
     * @return recurso id do Layout
     */
    @LayoutRes
    abstract fun getLayoutId(): Int


    /**
     * Substitui o viewModel definida
     *
     * @return view model instance
     */

    val viewModel: VM by lazy { getViewModel<VM>(viewModelClass) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewInflate = inflater.inflate(getLayoutId(), container, false)

        return viewInflate
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


}
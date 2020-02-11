package com.marvel.detailcharacter.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.marvel.common.base.BaseFragment
import com.marvel.detailcharacter.R
import com.marvel.detailcharacter.viewmodel.DetailCharacterViewModel

class DetailCharacterFragment : BaseFragment<DetailCharacterViewModel>(DetailCharacterViewModel::class) {

    override fun getLayoutId() = R.layout.fragment_detail_character

    private val TAG = DetailCharacterFragment::class.java.simpleName

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadCharactrs()

    }

    /**
     * Método de carregamento do personagem.
     **/
    private fun loadCharactrs() {

        viewModel.getData(activity!!.intent.getLongExtra("CHARACTER_ID_KEY",0))
        viewModel.resultCharacter.observe(this, Observer {
            it.code
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView")
        return super.onCreateView(inflater, container, savedInstanceState)

    }
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

}

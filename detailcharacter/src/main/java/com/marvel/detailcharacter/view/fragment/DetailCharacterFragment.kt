package com.marvel.detailcharacter.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import coil.api.load
import com.marvel.common.base.BaseFragment
import com.marvel.detailcharacter.R
import com.marvel.detailcharacter.viewmodel.DetailCharacterViewModel
import kotlinx.android.synthetic.main.fragment_detail_character.*

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
            iv_character_profile.load("${it.thumbnail.path}.${it.thumbnail.extension}")
            tv_hero_name.text = it.name
            tv_description.text = it.description
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

package br.com.marvel.featurehome.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.marvel.common.base.BaseFragment
import br.com.marvel.featurehome.view.adapter.CharacterAdapter
import br.com.marvel.featurehome.viewmodel.CharactersViewModel
import br.com.marvel.navigation.features.SampleNavigation
import com.marvel.featurehome.R
import kotlinx.android.synthetic.main.fragment_characters.*

class CharactersFragment : BaseFragment<CharactersViewModel>(CharactersViewModel::class), CharacterAdapter.OnClickCharacter {

    override fun getLayoutId() = R.layout.fragment_characters

    private val TAG = CharactersFragment::class.java.simpleName

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadCharacters()

        swipe_refresh.setOnRefreshListener {
            loadCharacters()
        }

    }

    /**
     * Método de carregamento dos personagens.
     **/
    private fun loadCharacters() {
        viewModel.resultCharacter.observe(this, Observer {
            rv_last_characteres_update.layoutManager = GridLayoutManager(context, 2)
            rv_last_characteres_update.adapter = CharacterAdapter(it.data.results,this)
            rv_last_characteres_update.visibility = View.VISIBLE
            //rv_last_characteres_update.addItemDecoration(GridItemDecorator(context!!,8,200))
            swipe_refresh.isRefreshing = false

            sfl_character.visibility = View.GONE

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

    override fun onClick(idCharacter: Long?) {
        toFeatureDetail(idCharacter)
    }

    private fun toFeatureDetail(idCharacter: Long?) = SampleNavigation.dynamicStart2?.let { startActivity(it) }
}

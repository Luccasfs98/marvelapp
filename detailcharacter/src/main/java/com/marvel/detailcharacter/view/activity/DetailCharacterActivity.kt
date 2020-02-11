package com.marvel.detailcharacter.view.activity

import android.os.Bundle
import br.com.marvel.common.view.WithoutNetworkDialog
import br.com.marvel.common.base.BaseActivity
import com.marvel.detailcharacter.R
import com.marvel.detailcharacter.di.viewModelFeatureDetailCharacterModule
import com.marvel.detailcharacter.viewmodel.DetailCharacterActivityViewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

class DetailCharacterActivity : BaseActivity<DetailCharacterActivityViewModel>(DetailCharacterActivityViewModel::class) {

    private val TAG = DetailCharacterActivity::class.java.simpleName

    private lateinit var dialog: WithoutNetworkDialog

    override fun getLayoutId() = R.layout.activity_detail_character

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        statusBarDarkOn()
        loadKoinModules(viewModelFeatureDetailCharacterModule)
        dialog = WithoutNetworkDialog(this)

    }

    /**
     * Método chamado na destruição da Activity, fazendo a desvinculação do Koin na mesma.
     * */
    override fun onDestroy() {
        super.onDestroy()
        unloadKoinModules(viewModelFeatureDetailCharacterModule)
    }

    /**
     * Método que mostra se esta com rede
     * */
    override fun onConnectivityChanged(isConnected: Boolean) {
        super.onConnectivityChanged(isConnected)
        if (!isConnected)
           dialog.show()
        else
            if (dialog.isShowing())
                dialog.dismiss()
    }

}

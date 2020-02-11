package br.com.marvel.featurehome.view.activity

import android.os.Bundle
import br.com.marvel.common.view.WithoutNetworkDialog
import br.com.marvel.common.base.BaseActivity
import br.com.marvel.featurehome.di.viewModelFeatureHomeModule
import br.com.marvel.featurehome.viewmodel.HomeViewModel
import com.marvel.featurehome.R
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

class HomeActivity : BaseActivity<HomeViewModel>(HomeViewModel::class) {

    private val TAG = HomeActivity::class.java.simpleName

    private lateinit var dialog: WithoutNetworkDialog

    override fun getLayoutId() = R.layout.activity_home

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        statusBarDarkOn()
        loadKoinModules(viewModelFeatureHomeModule)
        dialog = WithoutNetworkDialog(this)

    }

    /**
     * Método chamado na destruição da Activity, fazendo a desvinculação do Koin na mesma.
     * */
    override fun onDestroy() {
        super.onDestroy()
        unloadKoinModules(viewModelFeatureHomeModule)
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

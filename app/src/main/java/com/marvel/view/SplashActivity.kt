package com.marvel.view

import android.os.Bundle
import android.os.Handler
import br.com.marvel.common.base.BaseActivity
import br.com.marvel.navigation.features.SampleNavigation
import com.marvel.R
import com.marvel.viewmodel.SplashViewModel

class SplashActivity :
    BaseActivity<SplashViewModel>(SplashViewModel::class) {

    override fun getLayoutId() = R.layout.activity_splash

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        statusBarLightOn()
        Handler().postDelayed({
            startHome()
            finish()
        },2000)
    }

    /**
     * Abre a Tela de Home
     * */
    private fun startHome() = SampleNavigation.dynamicStart?.let { startActivity(it) }

}
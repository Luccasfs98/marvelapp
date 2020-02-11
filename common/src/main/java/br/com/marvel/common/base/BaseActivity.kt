package br.com.marvel.common.base

import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import com.marvel.common.ConnectivityChangeReceiver
import com.marvel.common.R
import com.jaeger.library.StatusBarUtil
import org.koin.android.viewmodel.ext.android.getViewModel
import kotlin.reflect.KClass

abstract class BaseActivity<out VM : ViewModel>(viewModelClass: KClass<VM>) :
    AppCompatActivity(), ConnectivityChangeReceiver.OnConnectivityChangedListener {

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

    lateinit var connectivityChangeReceiver: ConnectivityChangeReceiver


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        connectivityChangeReceiver = ConnectivityChangeReceiver(this)
        val filter = IntentFilter()
        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE")
        registerReceiver(connectivityChangeReceiver, filter)
        setContentView(getLayoutId())
    }

    override fun onConnectivityChanged(isConnected: Boolean) {}

    /**
     * Método de alterar cor do status bar para escuro
     * */
    fun statusBarLightOn() {
        StatusBarUtil.setLightMode(this)
        StatusBarUtil.setTransparent(this)

    }

    /**
     * Método de alterar cor do status bar para claro
     **/
    fun statusBarDarkOn() {
        StatusBarUtil.setTransparent(this)
        StatusBarUtil.setColorNoTranslucent(
            this,
            ContextCompat.getColor(this, R.color.colorStatusBar)
        )
        StatusBarUtil.setDarkMode(this)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(connectivityChangeReceiver)
    }

}
package com.marvel.common

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build


class ConnectivityChangeReceiver(private val listener: OnConnectivityChangedListener) :
    BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val isConnected = getStatusConnect(connectivityManager)
        listener.onConnectivityChanged(isConnected)
    }

    interface OnConnectivityChangedListener {
        fun onConnectivityChanged(isConnected: Boolean)
    }

    /**
     * Método retorna o status da conexão.
     * */
    private fun getStatusConnect(connectivityManager: ConnectivityManager): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val nw = connectivityManager.activeNetwork ?: return false
            val actNw = connectivityManager.getNetworkCapabilities(nw) ?: return false
            return when {
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                //for other device how are able to connect with Ethernet
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else -> false
            }
        } else {
            val nwInfo = connectivityManager.activeNetworkInfo ?: return false
            return nwInfo.isConnected
        }
    }

}
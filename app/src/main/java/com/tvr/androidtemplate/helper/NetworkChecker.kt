package com.tvr.androidtemplate.helper

/**
 * Created By Tanvir Hasan on 2/10/24 3:41PM
 * Email: tanvirhasan553@gmail.com
 */
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import com.tvr.androidtemplate.MyApp
class NetworkChecker {
    companion object{
        public fun isInternetConnected(): Boolean {
            val connectivityManager = MyApp.instance.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val network  = connectivityManager.activeNetwork ?: return false
            val networkCapabilities = connectivityManager.getNetworkCapabilities(network) ?: return false
            return when {
                networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH) -> true
                else -> false
            }
        }
    }
}
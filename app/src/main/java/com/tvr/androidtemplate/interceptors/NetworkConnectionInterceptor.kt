package com.tvr.androidtemplate.interceptors

import com.tvr.androidtemplate.MyApp
import com.tvr.androidtemplate.R
import com.tvr.androidtemplate.helper.NetworkChecker
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException


/**
 *Created By Tanvir Hasan on 2/10/24 3:55PM
 *Email: tanvirhasan553@gmail.com
 */
class NetworkConnectionInterceptor :Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        if(!NetworkChecker.isInternetConnected()){
            throw NoConnectivityException()
        }
        return chain.proceed(chain.request())
    }
}

class NoConnectivityException : IOException() {
    override val message: String
        get() = MyApp.instance.getString(R.string.no_internet_connection)
}
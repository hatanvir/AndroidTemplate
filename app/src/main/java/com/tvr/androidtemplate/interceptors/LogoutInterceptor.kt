package com.tvr.androidtemplate.interceptors

import com.tvr.androidtemplate.MyApp
import com.tvr.androidtemplate.R
import com.tvr.androidtemplate.data.local.SharedPref
import okhttp3.Interceptor
import okhttp3.Response
import okio.IOException

/**
 * Created By Tanvir Hasan on 2/17/24 9:45PM
 * Email: tanvirhasan553@gmail.com
 *
 * Created this interceptor to logout while any 401 status code throw
 * not using this for this project
 * added for quick use in near future
 */
class LogoutInterceptor :Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        //we are not going to logout from login api
        //that's why we have added the logic
        if (chain.request().url.toUrl().path != "login") {
            val response = chain.proceed(chain.request())
            if(response.code == 401){
                //do logout
                throw LogoutException()
            }
        }
        return chain.proceed(chain.request())
    }
}

/**
 * New exception to detect logout
 */
class LogoutException : IOException() {
    override val message: String
        get() = MyApp.instance.getString(R.string.token_expired)
}
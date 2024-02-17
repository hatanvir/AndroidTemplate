package com.tvr.androidtemplate.interceptors

import com.tvr.androidtemplate.data.local.SharedPref
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created By Tanvir Hasan on 2/17/24 9:24PM
 * Email: tanvirhasan553@gmail.com
 *
 * Created the interceptor to add token on header to our request
 * not using this for this project
 * added for quick use in near future
 */
class TokenSetupInterceptor constructor(
    private val sharedPref: SharedPref
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val token = sharedPref.getValue(SharedPref.TOKEN, "test") as String
        var modifiedRequest = chain.request()
        //we are not going to add token on login api
        //that's why we have added the logic
        if (chain.request().url.toUrl().path != "login") {
            //checking our token is empty or not
            //if empty generate new one
            if (token.isEmpty()) {
                //generate token here
            } else {
                modifiedRequest = chain.request()
                    .newBuilder()
                    .addHeader("Authorization", token)
                    .build()
            }
        }
        return chain.proceed(modifiedRequest)
    }
}
package com.tvr.androidtemplate

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Created By Tanvir Hasan
 * Email: tanvirhasan553@gmail.com
 */
@HiltAndroidApp
class MyApp: Application() {
    companion object{
        lateinit var instance: Application
    }
    override fun onCreate() {
        super.onCreate()
        instance = this
    }
    fun getServerBaseUrl():String{
        return getString(R.string.default_server_url);
    }
}

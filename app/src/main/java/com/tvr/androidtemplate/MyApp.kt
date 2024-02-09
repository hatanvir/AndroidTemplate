package com.tvr.androidtemplate

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

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

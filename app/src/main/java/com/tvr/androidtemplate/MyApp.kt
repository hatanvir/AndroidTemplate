package com.tvr.androidtemplate

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApp: Application() {
    fun getServerBaseUrl():String{
        return getString(R.string.default_server_url);
    }
}

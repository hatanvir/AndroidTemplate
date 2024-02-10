package com.tvr.androidtemplate.helper

import android.widget.Toast
import com.tvr.androidtemplate.MyApp

/**
 * Created By Tanvir Hasan on 2/10/24 4:17 PM
 * Email: tanvirhasan553@gmail.com
 */
class CustomToast {
    companion object{
        fun showToast(msg:String) = Toast.makeText(MyApp.instance,msg,Toast.LENGTH_SHORT).show()
    }
}
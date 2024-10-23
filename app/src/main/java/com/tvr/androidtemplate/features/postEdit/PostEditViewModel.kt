package com.tvr.androidtemplate.features.postEdit

import androidx.lifecycle.MutableLiveData
import com.tvr.androidtemplate.base.BaseViewModel
import com.tvr.androidtemplate.data.models.Post

/**
 * Created By Tanvir Hasan on 2/16/24 6:44 AM
 * Email: tanvirhasan553@gmail.com
 */
class PostEditViewModel : BaseViewModel<Post>() {
    var mutableTitle = MutableLiveData<String>()
}
package com.tvr.androidtemplate.features.post

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.tvr.androidtemplate.base.BaseViewModel
import com.tvr.androidtemplate.base.ViewState
import com.tvr.androidtemplate.data.BaseResponse
import com.tvr.androidtemplate.data.repository.post.PostRepositoryImp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    private var postRepositoryImp: PostRepositoryImp
):BaseViewModel<List<*>>() {
    fun getPost(){
        viewModelScope.launch {
            postRepositoryImp.getPost()
                .onStart { ViewState.Loading }
                .collect{
                    when(it){
                        is BaseResponse.Success-> _data.value = ViewState.Success(it.data as List<*>)
                        else -> _data.value = ViewState.Error(it.data.toString())
                    }
                }
        }
    }
}
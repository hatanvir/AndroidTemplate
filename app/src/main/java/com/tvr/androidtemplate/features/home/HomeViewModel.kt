package com.tvr.androidtemplate.features.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tvr.androidtemplate.data.BaseResponse
import com.tvr.androidtemplate.data.repository.post.PostRepositoryImp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private var postRepositoryImp: PostRepositoryImp
):ViewModel() {
    fun getPost(){
        viewModelScope.launch {
            postRepositoryImp.getPostRemote()
                .collect{
                    when(it){
                        is BaseResponse.Success-> Log.d("dataaaa", it.data.toString())
                        else -> Log.d("dataaaaerr", it.data.toString())
                    }
                }
        }
    }
}
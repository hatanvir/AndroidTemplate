package com.tvr.androidtemplate.features.post

import androidx.lifecycle.viewModelScope
import com.tvr.androidtemplate.base.BaseViewModel
import com.tvr.androidtemplate.base.ViewState
import com.tvr.androidtemplate.data.BaseResponse
import com.tvr.androidtemplate.data.models.Post
import com.tvr.androidtemplate.data.repository.post.PostRepositoryImp
import com.tvr.androidtemplate.features.post.adapters.PostRecyclerviewAdapter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    private var postRepositoryImp: PostRepositoryImp
):BaseViewModel<List<Post>>() {
    val postAdapter: PostRecyclerviewAdapter =  PostRecyclerviewAdapter(emptyList())

    fun getPost(){
        viewModelScope.launch {
            postRepositoryImp.getPost()
                .onStart { ViewState.Loading }
                .collect{
                    when(it){
                        is BaseResponse.Success-> {
                            _data.value = ViewState.Success(it.data as List<Post>)
                            (_data.value as ViewState.Success<List<Post>>).data?.let { it1 ->
                                postAdapter.updatePosts(
                                    it1
                                )
                            }
                        }
                        else -> _data.value = ViewState.Error(it.data.toString())
                    }
                }
        }
    }
}
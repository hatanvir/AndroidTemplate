package com.tvr.androidtemplate.features.post

import androidx.lifecycle.viewModelScope
import com.tvr.androidtemplate.MyApp
import com.tvr.androidtemplate.R
import com.tvr.androidtemplate.base.BaseViewModel
import com.tvr.androidtemplate.base.ViewState
import com.tvr.androidtemplate.data.models.Post
import com.tvr.androidtemplate.data.repository.post.PostRepositoryImp
import com.tvr.androidtemplate.features.post.adapters.PostRecyclerviewAdapter
import com.tvr.androidtemplate.helper.CustomToast
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created By Tanvir Hasan
 * Email: tanvirhasan553@gmail.com
 */
@HiltViewModel
class PostViewModel @Inject constructor(
    private var postRepositoryImp: PostRepositoryImp,
) : BaseViewModel<List<Post>>() {
    val postAdapter: PostRecyclerviewAdapter = PostRecyclerviewAdapter(emptyList())

    /**
     * getting post list here
     */
    fun getPost() {
        viewModelScope.launch {
            postRepositoryImp.getPostRemote()
                .flowOn(Dispatchers.IO)
                .onStart { _data.value = ViewState.Loading }
                .catch {
                    handleException(it.message)
                }
                .collect {
                    _data.value = ViewState.Success(it)
                    (_data.value as ViewState.Success<List<Post>>).data?.let { it1 ->
                        postAdapter.updatePosts(
                            it1
                        )
                    }
                }
        }
}

//this segment will call when some error happens
//like network error and other error
//here we are getting data from local db
private suspend fun handleException(message: String?) {
    CustomToast.showToast(message?:MyApp.instance.getString(R.string.something_went_wrong))
    postRepositoryImp.getPostLocal()
        .flowOn(Dispatchers.IO)
        .catch {
            _data.value = ViewState.Error(
                it.localizedMessage ?: MyApp.instance.getString(R.string.something_went_wrong)
            )
        }
        .collect {
            _data.value = ViewState.Success(it)
            (_data.value as ViewState.Success<List<Post>>).data?.let { it1 ->
                postAdapter.updatePosts(
                    it1
                )
            }
        }
}
}
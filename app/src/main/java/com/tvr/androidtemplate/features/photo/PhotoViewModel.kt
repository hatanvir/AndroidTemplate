package com.tvr.androidtemplate.features.photo

import androidx.lifecycle.viewModelScope
import com.tvr.androidtemplate.MyApp
import com.tvr.androidtemplate.R
import com.tvr.androidtemplate.base.BaseViewModel
import com.tvr.androidtemplate.base.ViewState
import com.tvr.androidtemplate.data.models.Photo
import com.tvr.androidtemplate.data.repository.photo.PhotoRepositoryImp
import com.tvr.androidtemplate.features.photo.adapters.PhotoRecyclerviewAdapter
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
class PhotoViewModel @Inject constructor(
    private var photoRepositoryImp: PhotoRepositoryImp
) : BaseViewModel<List<Photo>>() {
    val photoAdapter: PhotoRecyclerviewAdapter = PhotoRecyclerviewAdapter(emptyList())

    /**
     * getting photo list here
     */
    fun getPhotos() {
        viewModelScope.launch {
            photoRepositoryImp.getPhotoRemote()
                .flowOn(Dispatchers.IO)
                .onStart { _data.value = ViewState.Loading }
                .catch {
                    handleException(it.message)
                }
                .collect {
                    _data.value = ViewState.Success(it)
                    (_data.value as ViewState.Success<*>).data?.let { it1 ->
                        photoAdapter.updatePhotos(
                            it1 as List<Photo>
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
        photoRepositoryImp.getPhotoLocal()
            .flowOn(Dispatchers.IO)
            .catch {
                _data.value = ViewState.Error(
                    it.localizedMessage ?: MyApp.instance.getString(R.string.something_went_wrong)
                )
            }
            .collect {
                _data.value = ViewState.Success(it)
                (_data.value as ViewState.Success<*>).data?.let { it1 ->
                    photoAdapter.updatePhotos(
                        it1 as List<Photo>
                    )
                }
            }
    }
}
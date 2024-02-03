package com.tvr.androidtemplate.base
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tvr.androidtemplate.data.local.RoomDb
import com.tvr.androidtemplate.data.local.SharedPref
import com.tvr.androidtemplate.data.remote.services.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

abstract class BaseViewModel<T> : ViewModel() {
    @Inject
    lateinit var sharedPref: SharedPref

    protected val _data = MutableStateFlow<ViewState<T>>(ViewState.Loading)
    protected val progressBarVisibility = MutableLiveData<ViewState<T>>()
    protected val errorVisibility = MutableLiveData<ViewState<T>>()

    val data: StateFlow<ViewState<T>> = _data
}
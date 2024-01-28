package com.tvr.androidtemplate.features.post.binding

import android.opengl.Visibility
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tvr.androidtemplate.base.ViewState
import com.tvr.androidtemplate.data.models.Post
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import androidx.lifecycle.lifecycleScope

@BindingAdapter("setupPostRecyclerView")
fun setupPostRecyclerView(
    recyclerView: RecyclerView,
    postFlow: StateFlow<ViewState<List<*>>>?
) {
    if (postFlow?.value is ViewState.Success) {
        Log.d("DDDDD_SUCC", "success")
    }
}

@BindingAdapter("progressbarVisibility")
fun setupPostRecyclerView(
    view: View,
    postFlow: StateFlow<ViewState<List<*>>>?
) {

    if (postFlow?.value is ViewState.Loading) {
        view.visibility = View.VISIBLE
        Log.d("DDDDD_SUCC", "loading")
    }else if(postFlow?.value is ViewState.Success ||
        postFlow?.value is ViewState.Error){
        view.visibility = View.GONE;
        Log.d("DDDDD_SUCC", "succc")
    }
}


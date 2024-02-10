package com.tvr.androidtemplate.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tvr.androidtemplate.R
import com.tvr.androidtemplate.base.BaseViewHolder

@BindingAdapter("setList")
fun setListAdapter(recyclerView: RecyclerView, adapter: RecyclerView.Adapter<BaseViewHolder>) {
    recyclerView.adapter = adapter
    //recyclerView.addItemDecoration(Inset(recyclerView.context))
}

@BindingAdapter("setImage")
fun setImageAdapter(imageView: ImageView, url:String) {
    Glide.with(imageView.context)
        .load(url)
        .error(R.drawable.baseline_photo_24)
        .into(imageView)
}
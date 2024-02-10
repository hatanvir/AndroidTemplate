package com.tvr.androidtemplate.features.photo.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tvr.androidtemplate.R
import com.tvr.androidtemplate.base.BaseViewHolder

@BindingAdapter("setImage")
fun setImageAdapter(imageView: ImageView, url:String) {
    Glide.with(imageView.context)
        .load(url)
        .error(R.drawable.baseline_photo_24)
        .into(imageView)
}
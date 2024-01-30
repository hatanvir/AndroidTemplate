package com.tvr.androidtemplate.features.post.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tvr.androidtemplate.base.BaseViewHolder

@BindingAdapter("setList")
fun setListAdapter(recyclerView: RecyclerView, adapter: RecyclerView.Adapter<BaseViewHolder>) {
    recyclerView.adapter = adapter
    //recyclerView.addItemDecoration(Inset(recyclerView.context))
}
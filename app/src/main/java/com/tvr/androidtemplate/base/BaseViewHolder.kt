package com.tvr.androidtemplate.base

import android.view.View
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
    abstract fun onBindView(dataItem: Any)
}
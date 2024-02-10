package com.tvr.androidtemplate.base

import android.view.View
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

/**
 * Created By Tanvir Hasan
 * Email: tanvirhasan553@gmail.com
 */
abstract class BaseViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
    abstract fun onBindView(dataItem: Any)
}
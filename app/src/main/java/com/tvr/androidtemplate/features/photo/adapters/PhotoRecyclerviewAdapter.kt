package com.tvr.androidtemplate.features.photo.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.tvr.androidtemplate.R
import com.tvr.androidtemplate.base.BaseViewHolder
import com.tvr.androidtemplate.data.models.Photo
import com.tvr.androidtemplate.databinding.ItemPhotoBinding
/**
 * Created By Tanvir Hasan
 * Email: tanvirhasan553@gmail.com
 */
class PhotoRecyclerviewAdapter(private var photoList: List<Photo>) : RecyclerView.Adapter<BaseViewHolder>() {

    fun updatePhotos(items: List<Photo>) {
        photoList = items
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
       return PhotoListHolder(DataBindingUtil.inflate(
           LayoutInflater.from(parent.context),
           R.layout.item_photo, parent, false))
    }

    override fun getItemCount(): Int {
        return photoList.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        photoList[position].let { holder.onBindView(it) }
    }
}


class PhotoListHolder(private val itemBinding: ItemPhotoBinding): BaseViewHolder(itemBinding.root) {
    override fun onBindView(dataItem: Any) {
        itemBinding.photo = dataItem as Photo
    }
}
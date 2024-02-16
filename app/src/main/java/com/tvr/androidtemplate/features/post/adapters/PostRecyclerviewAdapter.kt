package com.tvr.androidtemplate.features.post.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.tvr.androidtemplate.R
import com.tvr.androidtemplate.base.BaseViewHolder
import com.tvr.androidtemplate.data.models.Post
import com.tvr.androidtemplate.databinding.ItemPostBinding
import com.tvr.androidtemplate.listeners.PostItemClickListeners

/**
 * Created By Tanvir Hasan
 * Email: tanvirhasan553@gmail.com
 */
class PostRecyclerviewAdapter(
    private var postList: List<Post>,
    private var postItemClickListeners: PostItemClickListeners
) :
    RecyclerView.Adapter<BaseViewHolder>() {
    fun updatePosts(items: List<Post>) {
        postList = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return PostListHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_post, parent, false
            ), postItemClickListeners
        )
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        postList[position].let { holder.onBindView(it) }
    }

    class PostListHolder(
        private val itemBinding: ItemPostBinding,
        private var postItemClickListeners: PostItemClickListeners
    ) :
        BaseViewHolder(itemBinding.root) {
        override fun onBindView(dataItem: Any) {
            itemBinding.post = dataItem as Post
            itemBinding.editIm.setOnClickListener {
                postItemClickListeners.onClickEdit(dataItem)
            }
        }
    }
}

package com.tvr.androidtemplate.data.local.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tvr.androidtemplate.data.models.Post

@Entity
class PostDto(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val body: String = "",
    val title: String = ""
){
    companion object {
        fun toPosts(posDtos: List<PostDto>): List<Post> {
            val posts = arrayListOf<Post>()

            posDtos.forEach { posts.add(it.toPost(it)) }

            return posts
        }
    }

    fun toPost(post: PostDto): Post {
        return Post(
            id = post.id,
            title = post.title,
            body = post.body
        )
    }
}

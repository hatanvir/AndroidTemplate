package com.tvr.androidtemplate.data.local.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tvr.androidtemplate.data.models.Post

/**
 * Created By Tanvir Hasan
 * Email: tanvirhasan553@gmail.com
 *
 * this class is responsible to handle local data
 */
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

            posDtos.forEach { posts.add(it.toPost()) }

            return posts
        }
    }

    fun toPost(): Post {
        return Post(
            id = id,
            title = title,
            body = body
        )
    }
}

package com.tvr.androidtemplate.data.models

import android.os.Parcelable

import com.google.gson.annotations.SerializedName
import com.tvr.androidtemplate.data.local.dto.PostDto

/**
 * Created By Tanvir Hasan
 * Email: tanvirhasan553@gmail.com
 */
class Post(
    var userId : Int    = 0,
    var id     : Int    = 0,
    var title  : String = "",
    var body   : String = ""
) {
    companion object{
        fun toPostDTOs(posts: List<Post>): List<PostDto> {
            val postDTOs = arrayListOf<PostDto>()

            posts.forEach { postDTOs.add(it.toPostDTO()) }

            return postDTOs
        }
    }

    fun toPostDTO(): PostDto {
        return  PostDto(
            id = id,
            body = body,
            title = title
        )
    }
}

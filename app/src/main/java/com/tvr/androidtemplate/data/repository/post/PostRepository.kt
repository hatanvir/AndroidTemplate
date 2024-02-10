package com.tvr.androidtemplate.data.repository.post

import com.tvr.androidtemplate.data.BaseResponse
import com.tvr.androidtemplate.data.local.dto.PostDto
import com.tvr.androidtemplate.data.models.Post
import kotlinx.coroutines.flow.Flow

/**
 * Created By Tanvir Hasan
 * Email: tanvirhasan553@gmail.com
 */
interface PostRepository {

    fun insertPostsLocal(posts:List<PostDto>)
    fun getPostLocal(): Flow<List<Post>>
    suspend fun getPostRemote(): Flow<List<Post>>
}
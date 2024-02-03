package com.tvr.androidtemplate.data.repository.post

import com.tvr.androidtemplate.data.BaseResponse
import com.tvr.androidtemplate.data.local.dto.PostDto
import com.tvr.androidtemplate.data.models.Post
import kotlinx.coroutines.flow.Flow

interface PostRepository {

    fun insertPostsLocal(posts:List<PostDto>)
    fun getPostLocal(): List<PostDto>
    suspend fun getPostRemote(): Flow<BaseResponse<Any>>
}
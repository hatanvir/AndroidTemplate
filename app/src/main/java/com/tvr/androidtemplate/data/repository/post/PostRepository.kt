package com.tvr.androidtemplate.data.repository.post

import com.tvr.androidtemplate.data.BaseResponse
import com.tvr.androidtemplate.data.models.Post
import kotlinx.coroutines.flow.Flow

interface PostRepository {
    suspend fun getPost(): Flow<BaseResponse<Any>>
}
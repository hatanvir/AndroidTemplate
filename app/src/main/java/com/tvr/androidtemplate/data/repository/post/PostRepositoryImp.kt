package com.tvr.androidtemplate.data.repository.post

import com.tvr.androidtemplate.data.BaseResponse
import com.tvr.androidtemplate.data.models.Post
import com.tvr.androidtemplate.data.remote.dataSource.post.PostDataSource
import com.tvr.androidtemplate.data.remote.dataSource.post.PostDataSourceImp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PostRepositoryImp @Inject constructor(
    private var postDataSource: PostDataSourceImp
): PostRepository {
    override suspend fun getPost(): Flow<BaseResponse<Any>> {
        return flow {
            emit(postDataSource.getPost())
        }.flowOn(Dispatchers.IO)
    }
}
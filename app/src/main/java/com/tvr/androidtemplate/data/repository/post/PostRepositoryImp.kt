package com.tvr.androidtemplate.data.repository.post

import com.tvr.androidtemplate.data.BaseResponse
import com.tvr.androidtemplate.data.local.RoomDb
import com.tvr.androidtemplate.data.local.dto.PostDto
import com.tvr.androidtemplate.data.models.Post

import com.tvr.androidtemplate.data.remote.services.ApiService
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PostRepositoryImp @Inject constructor(
    private val apiService: ApiService,
    private val db: RoomDb
): PostRepository {
    override fun insertPostsLocal(posts: List<PostDto>) {
        db.getPostDao().insertAll(posts)
    }

    override fun getPostLocal(): Flow<List<Post>> {
       return flow { emit(PostDto.toPosts(db.getPostDao().getAll())) }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    override suspend fun getPostRemote(): Flow<BaseResponse<Any>> {
        return flow {
            emit(apiService.getPost())
        }.map {
            it.body()
        }.flatMapConcat {
            flow {
                insertPostsLocal(Post.toPostDTOs(it as List<Post>))
                emit(BaseResponse.Success(
                    data = getPostLocal().collect{ it },
                    statusCode = 200
                ))
            }
        }
    }


}
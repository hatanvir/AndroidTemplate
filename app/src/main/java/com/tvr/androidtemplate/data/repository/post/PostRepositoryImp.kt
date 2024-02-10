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

/**
 * Created By Tanvir Hasan
 * Email: tanvirhasan553@gmail.com
 */
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

    override suspend fun getPostRemote(): Flow<List<Post>> {
        return flow {
            insertPostsLocal(Post.toPostDTOs(apiService.getPost().body() as List<Post>))
            getPostLocal().collect{
                emit(it)
            }
        }
    }


}
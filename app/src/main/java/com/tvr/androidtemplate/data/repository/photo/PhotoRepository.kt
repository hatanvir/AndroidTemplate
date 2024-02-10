package com.tvr.androidtemplate.data.repository.photo

import com.tvr.androidtemplate.data.BaseResponse
import com.tvr.androidtemplate.data.local.dto.PhotoDto
import com.tvr.androidtemplate.data.local.dto.PostDto
import com.tvr.androidtemplate.data.models.Photo
import com.tvr.androidtemplate.data.models.Post
import kotlinx.coroutines.flow.Flow

/**
 * Created By Tanvir Hasan
 * Email: tanvirhasan553@gmail.com
 */
interface PhotoRepository {

    fun insertPhotosLocal(photos:List<PhotoDto>)
    fun getPhotoLocal(): Flow<List<Photo>>
    suspend fun getPhotoRemote(): Flow<List<Photo>>
}
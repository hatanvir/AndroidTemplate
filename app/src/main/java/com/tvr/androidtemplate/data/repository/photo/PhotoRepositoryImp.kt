package com.tvr.androidtemplate.data.repository.post

import android.util.Log
import com.tvr.androidtemplate.data.BaseResponse
import com.tvr.androidtemplate.data.local.RoomDb
import com.tvr.androidtemplate.data.local.dto.PhotoDto
import com.tvr.androidtemplate.data.local.dto.PostDto
import com.tvr.androidtemplate.data.models.Photo
import com.tvr.androidtemplate.data.models.Post

import com.tvr.androidtemplate.data.remote.services.ApiService
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import java.lang.NullPointerException
import javax.inject.Inject

class PhotoRepositoryImp @Inject constructor(
    private val apiService: ApiService,
    private val db: RoomDb
): PhotoRepository {
    override fun insertPhotosLocal(photos: List<PhotoDto>) {
        db.getPhotoDao().insertAll(photos)
    }

    override fun getPhotoLocal(): Flow<List<Photo>> {
        return flow { emit(PhotoDto.toPhotos(db.getPhotoDao().getAll())) }
    }

    override suspend fun getPhotoRemote(): Flow<List<Photo>> {
        return flow {
            insertPhotosLocal(Photo.toPhotoDTOs(apiService.getPhoto().body() as List<Photo>))
            getPhotoLocal().collect{
                emit(it)
            }
        }
    }

}
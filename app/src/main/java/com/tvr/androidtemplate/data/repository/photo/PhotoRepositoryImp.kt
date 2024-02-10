package com.tvr.androidtemplate.data.repository.photo

import com.tvr.androidtemplate.data.local.RoomDb
import com.tvr.androidtemplate.data.local.dto.PhotoDto
import com.tvr.androidtemplate.data.models.Photo

import com.tvr.androidtemplate.data.remote.services.ApiService
import com.tvr.androidtemplate.data.repository.photo.PhotoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Created By Tanvir Hasan
 * Email: tanvirhasan553@gmail.com
 */
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
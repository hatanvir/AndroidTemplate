package com.tvr.androidtemplate.data.local.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tvr.androidtemplate.data.models.Photo

/**
 * Created By Tanvir Hasan
 * Email: tanvirhasan553@gmail.com
 *
 *
 * this class is responsible to handle local data
 */
@Entity
class PhotoDto(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var albumId: Int = 0,
    var title: String = "",
    var url: String = "",
    var thumbnailUrl: String = ""
){
    companion object {
        fun toPhotos(photoDtos: List<PhotoDto>): List<Photo> {
            val photos = arrayListOf<Photo>()

            photoDtos.forEach { photos.add(it.toPhoto()) }

            return photos
        }
    }


    fun toPhoto(): Photo {
        return Photo(
            id = id,
            albumId = albumId,
            title = title,
            url = url,
            thumbnailUrl = thumbnailUrl
        )
    }
}

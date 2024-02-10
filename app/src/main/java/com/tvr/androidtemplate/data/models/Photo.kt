package com.tvr.androidtemplate.data.models

import com.tvr.androidtemplate.data.local.dto.PhotoDto
import com.tvr.androidtemplate.data.local.dto.PostDto

/**
 * Created By Tanvir Hasan
 * Email: tanvirhasan553@gmail.com
 */
class Photo(
    var albumId: Int = 0,
    var id: Int = 0,
    var title: String = "",
    var url: String = "",
    var thumbnailUrl: String = ""
) {
    companion object {
        fun toPhotoDTOs(photos: List<Photo>): List<PhotoDto> {
            val photoDTOs = arrayListOf<PhotoDto>()

            photos.forEach { photoDTOs.add(it.toPhotoDTO()) }

            return photoDTOs
        }
    }

    fun toPhotoDTO(): PhotoDto {
        return PhotoDto(
            id = id,
            albumId = albumId,
            title = title,
            url = url,
            thumbnailUrl = thumbnailUrl
        )
    }
}

package com.tvr.androidtemplate.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tvr.androidtemplate.data.local.dao.PhotoDao
import com.tvr.androidtemplate.data.local.dao.PostDao
import com.tvr.androidtemplate.data.local.dto.PhotoDto
import com.tvr.androidtemplate.data.local.dto.PostDto

/**
 * Created By Tanvir Hasan
 * Email: tanvirhasan553@gmail.com
 */
@Database(
    entities =
    [
        PostDto::class,
        PhotoDto::class

    ], version = 1
)
abstract class RoomDb : RoomDatabase() {
    abstract fun getPostDao(): PostDao
    abstract fun getPhotoDao(): PhotoDao
}
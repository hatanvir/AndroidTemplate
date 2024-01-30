package com.tvr.androidtemplate.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tvr.androidtemplate.data.local.dao.PostDao
import com.tvr.androidtemplate.data.local.dto.PostDto

@Database(entities = [PostDto::class], version = 1)
abstract class RoomDb: RoomDatabase() {
    abstract fun getPostDao(): PostDao
}
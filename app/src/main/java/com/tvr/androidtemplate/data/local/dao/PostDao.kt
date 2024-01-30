package com.tvr.androidtemplate.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import com.tvr.androidtemplate.data.local.dto.PostDto
import androidx.room.Query

@Dao
interface PostDao {
    @Query("SELECT * FROM post")
    fun getAll(): List<PostDto>

    @Insert
    fun insertAll(vararg users: PostDto)

    @Delete
    fun delete(user: PostDto)
}
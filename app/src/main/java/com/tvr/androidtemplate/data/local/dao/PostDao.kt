package com.tvr.androidtemplate.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.tvr.androidtemplate.data.local.dto.PostDto
import androidx.room.Query
import com.tvr.androidtemplate.data.models.Post
import kotlinx.coroutines.flow.Flow

@Dao
interface PostDao {
    @Query("SELECT * FROM PostDto")
    fun getAll(): List<PostDto>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(posts: List<PostDto>)

    @Delete
    fun delete(posts: PostDto)
}
package com.tvr.androidtemplate.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import com.tvr.androidtemplate.data.local.dto.Post
import androidx.room.Query

@Dao
interface PostDao {
    @Query("SELECT * FROM post")
    fun getAll(): List<Post>

    @Insert
    fun insertAll(vararg users: Post)

    @Delete
    fun delete(user: Post)
}
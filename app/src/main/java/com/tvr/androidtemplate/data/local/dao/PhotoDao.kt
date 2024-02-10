package com.tvr.androidtemplate.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.tvr.androidtemplate.data.local.dto.PostDto
import androidx.room.Query
import com.tvr.androidtemplate.data.local.dto.PhotoDto
import com.tvr.androidtemplate.data.models.Post
import kotlinx.coroutines.flow.Flow

/**
 * Created By Tanvir Hasan
 * Email: tanvirhasan553@gmail.com
 */
@Dao
interface PhotoDao {
    @Query("SELECT * FROM PhotoDto")
    fun getAll(): List<PhotoDto>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(photos: List<PhotoDto>)

    @Delete
    fun delete(photos: PhotoDto)
}
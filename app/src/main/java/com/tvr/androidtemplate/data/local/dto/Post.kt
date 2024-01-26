package com.tvr.androidtemplate.data.local.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Post(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val firstName: String?,
    val lastName: String?
)

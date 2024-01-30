package com.tvr.androidtemplate.data.local.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PostDto(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val firstName: String?,
    val lastName: String?
)

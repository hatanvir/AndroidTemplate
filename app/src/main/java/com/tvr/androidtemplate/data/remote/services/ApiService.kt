package com.tvr.androidtemplate.data.remote.services

import com.tvr.androidtemplate.data.models.Photo
import com.tvr.androidtemplate.data.models.Post
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created By Tanvir Hasan
 * Email: tanvirhasan553@gmail.com
 */
interface ApiService {
    @GET("/posts")
    suspend fun getPost(): Response<List<Post>>

    @GET("/photos")
    suspend fun getPhoto(): Response<List<Photo>>
}
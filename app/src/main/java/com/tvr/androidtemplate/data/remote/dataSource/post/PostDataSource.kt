package com.tvr.androidtemplate.data.remote.dataSource.post

import com.tvr.androidtemplate.data.BaseResponse

/**
 * Created By Tanvir Hasan
 * Email: tanvirhasan553@gmail.com
 */
interface PostDataSource {
    suspend fun getPost(): BaseResponse<Any>
}
package com.tvr.androidtemplate.data.remote.dataSource.post

import com.tvr.androidtemplate.data.BaseResponse

interface PostDataSource {
    fun getPost(): BaseResponse<Any>
}
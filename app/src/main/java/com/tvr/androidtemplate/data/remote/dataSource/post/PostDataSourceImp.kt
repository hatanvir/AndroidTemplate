package com.tvr.androidtemplate.data.remote.dataSource.post

import com.tvr.androidtemplate.data.BaseResponse
import com.tvr.androidtemplate.data.remote.services.ApiService
import java.util.concurrent.Flow
import javax.inject.Inject

class PostDataSourceImp @Inject constructor(
    apiService: ApiService
):PostDataSource {
    override fun getPost(): BaseResponse<Any> {
        TODO("Not yet implemented")
    }
}
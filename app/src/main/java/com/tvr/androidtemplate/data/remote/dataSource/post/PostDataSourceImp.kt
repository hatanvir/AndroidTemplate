package com.tvr.androidtemplate.data.remote.dataSource.post

import com.tvr.androidtemplate.data.BaseResponse
import com.tvr.androidtemplate.data.models.Post
import com.tvr.androidtemplate.data.remote.services.ApiService
import java.util.concurrent.Flow
import javax.inject.Inject

class PostDataSourceImp @Inject constructor(
    private var apiService: ApiService
) : PostDataSource {

    /**
     * getting post list from api
     */
    override suspend fun getPost(): BaseResponse<Any> {
        return try {
            val postResponse = apiService.getPost()
            return if (postResponse.isSuccessful) {
                BaseResponse.Success(
                    data = postResponse.body() as ArrayList<Post>,
                    statusCode = 200
                )
            } else {
                BaseResponse.Failed(
                    data = postResponse.errorBody() as Any,
                    statusCode = postResponse.code()
                )
            }

        } catch (e: Exception) {
            BaseResponse.Failed(data = e.localizedMessage as String, statusCode = 500)
        }
    }
}
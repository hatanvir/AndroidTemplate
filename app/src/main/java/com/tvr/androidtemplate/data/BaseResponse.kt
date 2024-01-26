package com.tvr.androidtemplate.data

sealed class BaseResponse<T>(
    val data: T? = null,
    val statusCode: Int? = null
) {
    class Success<T>(data: T,statusCode: Int?): BaseResponse<T>(data,statusCode)
    class Failed<T>(data: T,statusCode: Int?): BaseResponse<T>(data,statusCode)

}
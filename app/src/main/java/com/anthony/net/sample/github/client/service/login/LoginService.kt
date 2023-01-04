package com.anthony.net.sample.github.client.service.login

import com.anthony.net.sample.github.client.dto.response.common.User
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface LoginService {

    /**
     * 取得 User
     */
    @GET("users/{userName}")
    suspend fun getUser(@Path("userName") userName: String): User

}



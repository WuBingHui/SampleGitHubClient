package com.anthony.net.sample.github.client.service.login

import com.anthony.net.sample.github.client.model.common.User
import retrofit2.http.GET
import retrofit2.http.Path

interface LoginService {

    /**
     * 取得 User
     */
    @GET("users/{userName}")
    suspend fun getUser(@Path("userName") userName: String): User

}



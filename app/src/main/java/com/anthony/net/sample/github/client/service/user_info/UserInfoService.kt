package com.anthony.net.sample.github.client.service.user_info

import com.anthony.net.sample.github.client.model.login.Repository
import retrofit2.http.GET
import retrofit2.http.Path

interface UserInfoService {

    /**
     * 取得倉庫清單
     */
    @GET("users/{userName}/repos")
    suspend fun getRepositories(@Path("userName") userName: String): List<Repository>

}
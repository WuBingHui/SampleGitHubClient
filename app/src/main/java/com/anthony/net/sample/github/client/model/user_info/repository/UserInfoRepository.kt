package com.anthony.net.sample.github.client.model.user_info.repository

import com.anthony.net.sample.github.client.service.user_info.CommitsService
import com.anthony.net.sample.github.client.service.user_info.UserInfoService
import okhttp3.ResponseBody
import retrofit2.Response

class UserInfoRepository(private val userInfoService: UserInfoService) {

    suspend fun getRepositories(
        loginName:String
    ): Response<ResponseBody> = userInfoService.getRepositories(loginName)

}
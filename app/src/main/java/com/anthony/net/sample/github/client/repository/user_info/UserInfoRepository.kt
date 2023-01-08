package com.anthony.net.sample.github.client.repository.user_info

import com.anthony.net.sample.github.client.model.dto.response.Repository
import com.anthony.net.sample.github.client.service.user_info.UserInfoService

class UserInfoRepository(private val userInfoService: UserInfoService) {

    suspend fun getRepositories(
        loginName:String
    ): List<Repository> = userInfoService.getRepositories(loginName)

}
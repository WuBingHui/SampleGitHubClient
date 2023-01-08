package com.anthony.net.sample.github.client.repository.login

import com.anthony.net.sample.github.client.model.common.User
import com.anthony.net.sample.github.client.service.login.LoginService

class LoginRepository(private val loginService: LoginService) {

    suspend fun getUser(userName: String): User =
        loginService.getUser(userName)

}
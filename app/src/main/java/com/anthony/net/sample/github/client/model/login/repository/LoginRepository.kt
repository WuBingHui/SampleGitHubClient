package com.anthony.net.sample.github.client.model.login.repository

import com.anthony.net.sample.github.client.service.login.LoginService
import okhttp3.ResponseBody
import retrofit2.Response

class LoginRepository(private val loginService: LoginService) {

    suspend fun getUser(userName: String): Response<ResponseBody> =
        loginService.getUser(userName)

}
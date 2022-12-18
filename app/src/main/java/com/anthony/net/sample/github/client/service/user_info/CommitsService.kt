package com.anthony.net.sample.github.client.service.user_info

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CommitsService {

    /**
     * 取得提交的訊息列表
     */
    @GET("repos/{owner}/{repo}/comments")
    suspend fun getCommits(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): Response<ResponseBody>

}
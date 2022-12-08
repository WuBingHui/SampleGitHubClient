package com.anthony.net.sample.github.client.service

import com.anthony.net.sample.github.client.dto.response.Collaborators
import com.anthony.net.sample.github.client.dto.response.RepositoryCommits
import com.anthony.net.sample.github.client.dto.response.SearchUser
import com.anthony.net.sample.github.client.dto.response.UserRepository
import retrofit2.Response
import retrofit2.http.*

interface GithubClientService {

    /**
     * 取得倉庫清單
     */
    @GET("users/{userName}/repos")
    suspend fun getUserRepository(@Path("userName") userName: String): Response<UserRepository>

    /**
     * 取得搜尋的用戶列表
     */
    @GET("search/users")
    suspend fun getSearchList(@Query("q") userName: String): Response<SearchUser>


    /**
     * 取得提交的訊息列表
     */
    @GET("repos/{owner}/{repo}/comments")
    suspend fun getRepositoryCommits(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): Response<RepositoryCommits>

    /**
     * 取得合作人列表
     */
    @GET("repos/{owner}/{repo}/collaborators")
    suspend fun getCollaborators(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): Response<Collaborators>

}



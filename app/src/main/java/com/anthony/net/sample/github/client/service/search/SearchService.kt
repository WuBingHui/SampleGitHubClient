package com.anthony.net.sample.github.client.service.search

import com.anthony.net.sample.github.client.dto.response.SearchUsers
import retrofit2.Response
import retrofit2.http.*

interface SearchService {

    /**
     * 取得搜尋的用戶列表
     */
    @GET("search/users")
    suspend fun getSearchList(@Query("q") userName: String): Response<SearchUsers>

}



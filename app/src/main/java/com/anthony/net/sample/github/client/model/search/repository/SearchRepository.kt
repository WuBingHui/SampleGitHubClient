package com.anthony.net.sample.github.client.model.search.repository

import com.anthony.net.sample.github.client.dto.response.SearchUsers
import com.anthony.net.sample.github.client.service.search.SearchService
import retrofit2.Response

class SearchRepository(private val searchService: SearchService) {

    suspend fun getSearchList(userName: String): Response<SearchUsers> =
        searchService.getSearchList(userName)

}
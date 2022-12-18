package com.anthony.net.sample.github.client.model.user_info.repository

import com.anthony.net.sample.github.client.service.user_info.CommitsService
import okhttp3.ResponseBody
import retrofit2.Response

class CommitsRepository(private val commitsService: CommitsService) {

    suspend fun getCommits(
        owner: String, repo: String
    ): Response<ResponseBody> = commitsService.getCommits(
        owner, repo
    )

}
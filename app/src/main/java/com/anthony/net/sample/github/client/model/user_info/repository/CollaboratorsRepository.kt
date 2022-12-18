package com.anthony.net.sample.github.client.model.user_info.repository

import com.anthony.net.sample.github.client.service.user_info.CollaboratorsService
import okhttp3.ResponseBody
import retrofit2.Response

class CollaboratorsRepository(private val collaboratorsService: CollaboratorsService) {

    suspend fun getCollaborators(
        owner: String, repo: String
    ): Response<ResponseBody> = collaboratorsService.getCollaborators(
        owner, repo
    )

}
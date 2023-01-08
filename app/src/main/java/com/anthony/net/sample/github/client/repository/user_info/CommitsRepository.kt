package com.anthony.net.sample.github.client.repository.user_info

import com.anthony.net.sample.github.client.model.dto.response.Commit
import com.anthony.net.sample.github.client.service.user_info.CommitsService

class CommitsRepository(private val commitsService: CommitsService) {

    suspend fun getCommits(
        owner: String, repo: String
    ): List<Commit> = commitsService.getCommits(
        owner, repo
    )

}
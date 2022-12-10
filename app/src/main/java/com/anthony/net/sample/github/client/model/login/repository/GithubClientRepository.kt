package com.anthony.net.sample.github.client.model.login.repository

import com.anthony.net.sample.github.client.dto.response.Collaborators
import com.anthony.net.sample.github.client.dto.response.RepositoryCommits
import com.anthony.net.sample.github.client.dto.response.SearchUser
import com.anthony.net.sample.github.client.service.GithubClientService
import retrofit2.Response

class GithubClientRepository(private val githubClientService: GithubClientService) {

    suspend fun getSearchList(userName: String): Response<SearchUser> =
        githubClientService.getSearchList(userName)

    suspend fun getRepositoryCommits(
        owner: String, repo: String
    ): Response<RepositoryCommits> = githubClientService.getRepositoryCommits(
        owner, repo
    )

    suspend fun getCollaborators(
        owner: String, repo: String
    ): Response<Collaborators> = githubClientService.getCollaborators(
        owner, repo
    )

}
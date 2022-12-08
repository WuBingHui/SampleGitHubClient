package com.anthony.net.sample.github.client.dto.response

import com.anthony.net.sample.github.client.dto.response.common.User
import kotlinx.serialization.Serializable

@Serializable
class RepositoryCommits : ArrayList<RepositoryCommitsItem>()

@Serializable
data class RepositoryCommitsItem(
    val author_association: String,
    val body: String,
    val commit_id: String,
    val created_at: String,
    val html_url: String,
    val id: Int,
    val line: Int,
    val node_id: String,
    val path: String,
    val position: Int,
    val updated_at: String,
    val url: String,
    val user: User
)


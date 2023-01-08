package com.anthony.net.sample.github.client.model.user_info

import kotlinx.serialization.Serializable


@Serializable
data class Commit(
    val author: Author? = null,
    val comments_url: String,
    val commit: CommitInfo,
    val committer: Committer? = null,
    val html_url: String,
    val node_id: String,
    val parents: List<Parent>,
    val sha: String,
    val url: String
) : java.io.Serializable

@Serializable
data class Author(
    val avatar_url: String,
    val events_url: String,
    val followers_url: String,
    val following_url: String,
    val gists_url: String,
    val gravatar_id: String,
    val html_url: String,
    val id: Int,
    val login: String,
    val node_id: String,
    val organizations_url: String,
    val received_events_url: String,
    val repos_url: String,
    val site_admin: Boolean,
    val starred_url: String,
    val subscriptions_url: String,
    val type: String,
    val url: String
) : java.io.Serializable

@Serializable
data class CommitInfo(
    val author: AuthorX,
    val comment_count: Int,
    val committer: CommitterX,
    val message: String,
    val tree: Tree,
    val url: String,
    val verification: Verification
) : java.io.Serializable

@Serializable
data class Committer(
    val avatar_url: String,
    val events_url: String,
    val followers_url: String,
    val following_url: String,
    val gists_url: String,
    val gravatar_id: String,
    val html_url: String,
    val id: Int,
    val login: String,
    val node_id: String,
    val organizations_url: String,
    val received_events_url: String,
    val repos_url: String,
    val site_admin: Boolean,
    val starred_url: String,
    val subscriptions_url: String,
    val type: String,
    val url: String
) : java.io.Serializable

@Serializable
data class Parent(
    val html_url: String,
    val sha: String,
    val url: String
) : java.io.Serializable

@Serializable
data class AuthorX(
    val date: String,
    val email: String,
    val name: String
) : java.io.Serializable

@Serializable
data class CommitterX(
    val date: String,
    val email: String,
    val name: String
) : java.io.Serializable

@Serializable
data class Tree(
    val sha: String,
    val url: String
) : java.io.Serializable

@Serializable
data class Verification(
    val payload: String? = null,
    val reason: String,
    val signature: String? = null,
    val verified: Boolean
) : java.io.Serializable



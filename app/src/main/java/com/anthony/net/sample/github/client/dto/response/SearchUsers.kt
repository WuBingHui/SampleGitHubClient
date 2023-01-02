package com.anthony.net.sample.github.client.dto.response

import com.anthony.net.sample.github.client.dto.response.common.User
import kotlinx.serialization.Serializable

@Serializable
data class SearchUsers(
    val incomplete_results: Boolean,
    val items: List<User>,
    val total_count: Int
): java.io.Serializable


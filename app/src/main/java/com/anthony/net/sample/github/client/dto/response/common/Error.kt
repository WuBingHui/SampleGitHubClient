package com.anthony.net.sample.github.client.dto.response.common

import kotlinx.serialization.Serializable

@Serializable
data class Error(
    val documentation_url: String,
    val message: String
)
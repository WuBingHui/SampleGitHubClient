package com.anthony.net.sample.github.client.dto.request

import com.anthony.net.sample.github.client.BuildConfig
import kotlinx.serialization.Serializable

@Serializable
data class AuthRequest(

    val scopes: List<String> = listOf("user", "repo", "gist", "notifications"),
    val note: String = BuildConfig.APPLICATION_ID,
    val noteUrl: String = "",
    val client_id: String = "8f7213694e115df205fb",
    val client_secret: String ="82c57672382db5c7b528d79e283c398ad02e3c3f"

)


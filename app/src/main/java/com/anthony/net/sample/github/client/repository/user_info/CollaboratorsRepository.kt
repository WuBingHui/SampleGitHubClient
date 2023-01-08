package com.anthony.net.sample.github.client.repository.user_info

import com.anthony.net.sample.github.client.model.user_info.Collaborator
import com.anthony.net.sample.github.client.service.user_info.CollaboratorsService

class CollaboratorsRepository(private val collaboratorsService: CollaboratorsService) {

    suspend fun getCollaborators(
        owner: String, repo: String
    ): List<Collaborator> = collaboratorsService.getCollaborators(
        owner, repo
    )

}
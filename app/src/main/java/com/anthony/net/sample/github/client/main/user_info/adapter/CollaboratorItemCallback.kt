package com.anthony.net.sample.github.client.main.user_info.adapter

import androidx.recyclerview.widget.DiffUtil
import com.anthony.net.sample.github.client.dto.response.Collaborator

class CollaboratorItemCallback : DiffUtil.ItemCallback<Collaborator>() {

    override fun areItemsTheSame(oldItem: Collaborator, newItem: Collaborator): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Collaborator, newItem: Collaborator): Boolean {
        return oldItem.id == newItem.id
    }

}
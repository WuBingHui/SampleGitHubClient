package com.anthony.net.sample.github.client.main.user_info.adapter

import androidx.recyclerview.widget.DiffUtil
import com.anthony.net.sample.github.client.model.dto.response.Repository

class RepositoryItemCallback : DiffUtil.ItemCallback<Repository>() {

    override fun areItemsTheSame(oldItem: Repository, newItem: Repository): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Repository, newItem: Repository): Boolean {
        return oldItem.id == newItem.id
    }

}
package com.anthony.net.sample.github.client.main.user_info.adapter

import androidx.recyclerview.widget.DiffUtil
import com.anthony.net.sample.github.client.model.dto.response.Commit

class CommitItemCallback : DiffUtil.ItemCallback<Commit>() {

    override fun areItemsTheSame(oldItem: Commit, newItem: Commit): Boolean {
        return oldItem.node_id == newItem.node_id
    }

    override fun areContentsTheSame(oldItem: Commit, newItem: Commit): Boolean {
        return oldItem.node_id == newItem.node_id
    }

}
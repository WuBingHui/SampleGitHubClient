package com.anthony.net.sample.github.client.main.user_info.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.anthony.net.sample.github.client.R
import com.anthony.net.sample.github.client.databinding.ItemCommitBinding
import com.anthony.net.sample.github.client.dto.response.Commit

class CommitsAdapter(
    commitItemCallback: CommitItemCallback,
) :
    ListAdapter<Commit, CommitsAdapter.ViewHolder>(commitItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_commit,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(getItem(position))

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val viewBinding = ItemCommitBinding.bind(itemView)

        fun bind(item: Commit) {

            viewBinding.userName.text = item.commit?.committer?.name

            viewBinding.date.text = item.commit?.committer?.date

            viewBinding.message.text = item.commit?.message

        }

    }

}
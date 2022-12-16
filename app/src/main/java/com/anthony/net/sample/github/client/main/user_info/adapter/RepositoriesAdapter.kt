package com.anthony.net.sample.github.client.main.user_info.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.anthony.net.sample.github.client.R
import com.anthony.net.sample.github.client.databinding.ItemRepositoryBinding
import com.anthony.net.sample.github.client.dto.response.Repository
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions

class RepositoriesAdapter(
    repositoryItemCallback: RepositoryItemCallback,
    private val onRepositoryItemClick: OnRepositoryItemClick
) :
    ListAdapter<Repository, RepositoriesAdapter.ViewHolder>(repositoryItemCallback) {

    interface OnRepositoryItemClick {

        fun onRepositoryItemClick(position: Int)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_repository,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(getItem(position))

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private val viewBinding = ItemRepositoryBinding.bind(itemView)

        init {

            viewBinding.root.setOnClickListener(this)

        }

        fun bind(item: Repository) {

            Glide.with(itemView.context).load(item.owner.avatar_url)
                .apply(RequestOptions.bitmapTransform(CircleCrop()))
                .placeholder(R.drawable.git_icon)
                .into(viewBinding.userIcon)

            viewBinding.repositoryStar.text = item.stargazers_count.toString()

            viewBinding.repositoryBranch.text = item.forks_count.toString()

            viewBinding.repositoryOwner.text = item.owner.login

            viewBinding.repositoryName.text = item.name

            viewBinding.repositoryDescription.text = item.description

            viewBinding.repositoryLanguage.text = item.language

        }

        override fun onClick(v: View?) {

            onRepositoryItemClick.onRepositoryItemClick(adapterPosition)

        }

    }

}
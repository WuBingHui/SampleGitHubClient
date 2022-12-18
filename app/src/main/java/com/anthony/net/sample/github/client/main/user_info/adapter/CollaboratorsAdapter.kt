package com.anthony.net.sample.github.client.main.user_info.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.anthony.net.sample.github.client.R
import com.anthony.net.sample.github.client.databinding.ItemCollaboratorBinding
import com.anthony.net.sample.github.client.dto.response.Collaborator
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions

class CollaboratorsAdapter(
    collaboratorItemCallback: CollaboratorItemCallback,
) :
    ListAdapter<Collaborator, CollaboratorsAdapter.ViewHolder>(collaboratorItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_collaborator,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(getItem(position))

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val viewBinding = ItemCollaboratorBinding.bind(itemView)

        fun bind(item: Collaborator) {

            val context = itemView.context

            Glide.with(context).load(item.avatar_url)
                .apply(RequestOptions.bitmapTransform(CircleCrop()))
                .placeholder(R.drawable.git_icon)
                .into(viewBinding.collaboratorImg)

            viewBinding.collaboratorName.text = item.login

        }

    }

}
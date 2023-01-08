package com.anthony.net.sample.github.client.main.user_info.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.anthony.net.sample.github.client.R
import com.anthony.net.sample.github.client.databinding.ItemCollaboratorBinding
import com.anthony.net.sample.github.client.model.user_info.Collaborator
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions

class CollaboratorsAdapter(
    collaboratorItemCallback: CollaboratorItemCallback,
) :
    ListAdapter<Collaborator, CollaboratorsAdapter.ViewHolder>(collaboratorItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCollaboratorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(getItem(position))

    }

    inner class ViewHolder(private val viewBinding: ItemCollaboratorBinding) : RecyclerView.ViewHolder(viewBinding.root) {

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
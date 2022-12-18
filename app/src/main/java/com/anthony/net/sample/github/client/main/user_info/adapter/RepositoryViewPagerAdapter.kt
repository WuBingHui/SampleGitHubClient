package com.anthony.net.sample.github.client.main.user_info.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.anthony.net.sample.github.client.main.user_info.view.CollaboratorsFragment
import com.anthony.net.sample.github.client.main.user_info.view.CommitsFragment

class RepositoryViewPagerAdapter(
    fragmentActivity: FragmentActivity, private val userName: String, private val repoName: String
) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment = when (position) {
        0 -> CommitsFragment.newInstance(userName, repoName)
        1 -> CollaboratorsFragment.newInstance(userName, repoName)
        else -> CommitsFragment.newInstance(userName, repoName)
    }


}

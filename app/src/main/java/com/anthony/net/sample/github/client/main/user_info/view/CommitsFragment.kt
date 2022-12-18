package com.anthony.net.sample.github.client.main.user_info.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.anthony.net.sample.github.client.base.BaseFragment
import com.anthony.net.sample.github.client.databinding.FragmentCommitsBinding
import com.anthony.net.sample.github.client.main.user_info.viewmodel.CommitsViewModel
import org.koin.android.ext.android.inject

class CommitsFragment : BaseFragment() {

    private lateinit var viewBinding: FragmentCommitsBinding

    private val commitsViewModel: CommitsViewModel by inject()

    companion object {

        const val USER_NAME = "UserName"

        const val REPO_NAME = "RepoName"

        fun newInstance(userName: String, repoName: String) =
            CommitsFragment().apply {

                arguments = Bundle().apply {

                    this.putString(USER_NAME, userName)

                    this.putString(REPO_NAME, repoName)

                }
            }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewBinding = FragmentCommitsBinding.inflate(inflater, container, false)

        initView()

        initViewModel()

        return viewBinding.root
    }


    private fun initView() {


    }

    private fun initViewModel() {


    }

}
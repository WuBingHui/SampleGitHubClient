package com.anthony.net.sample.github.client.main.user_info.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.anthony.net.sample.github.client.base.BaseFragment
import com.anthony.net.sample.github.client.databinding.FragmentCollaboratorsBinding
import com.anthony.net.sample.github.client.main.user_info.viewmodel.CollaboratorsViewModel
import org.koin.android.ext.android.inject

class CollaboratorsFragment : BaseFragment() {

    private lateinit var viewBinding: FragmentCollaboratorsBinding

    private val collaboratorsViewModel: CollaboratorsViewModel by inject()

    companion object {

        const val USER_NAME = "UserName"

        const val REPO_NAME = "RepoName"

        fun newInstance(userName: String, repoName: String) =
            CollaboratorsFragment().apply {

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

        viewBinding = FragmentCollaboratorsBinding.inflate(inflater, container, false)

        return viewBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()

        initViewModel()

    }

    private fun initView() {

    }

    private fun initViewModel() {


    }

}
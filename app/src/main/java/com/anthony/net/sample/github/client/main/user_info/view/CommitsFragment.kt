package com.anthony.net.sample.github.client.main.user_info.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.anthony.net.sample.github.client.base.BaseFragment
import com.anthony.net.sample.github.client.databinding.FragmentCommitsBinding
import com.anthony.net.sample.github.client.main.user_info.adapter.CommitItemCallback
import com.anthony.net.sample.github.client.main.user_info.adapter.CommitsAdapter
import com.anthony.net.sample.github.client.main.user_info.viewmodel.CommitsViewModel
import com.anthony.net.sample.github.client.network.Status
import org.koin.android.ext.android.inject

class CommitsFragment : BaseFragment() {

    private lateinit var viewBinding: FragmentCommitsBinding

    private val commitsViewModel: CommitsViewModel by inject()

    private var commitsAdapter: CommitsAdapter? = null

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

        customLoadingDialog.show(activity?.supportFragmentManager?:childFragmentManager, customLoadingDialog.tag)

        val userName = arguments?.getString(CollaboratorsFragment.USER_NAME) ?: ""

        val repoName = arguments?.getString(CollaboratorsFragment.REPO_NAME) ?: ""

        commitsViewModel.getCommits(userName, repoName)

        return viewBinding.root
    }


    private fun initView() {

        commitsAdapter = CommitsAdapter(CommitItemCallback())

        val linearLayoutManager = LinearLayoutManager(context)

        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL

        viewBinding.commitsRecyclerView.layoutManager = linearLayoutManager

        viewBinding.commitsRecyclerView.adapter = commitsAdapter


    }

    private fun initViewModel() {

        commitsViewModel.onCommits.observe(viewLifecycleOwner, Observer { dto ->

            when (dto.status) {

                Status.SUCCESS -> {

                    commitsAdapter?.submitList(dto.data)

                }

                Status.FAILED -> {

                    Toast.makeText(context, dto.message, Toast.LENGTH_LONG).show()

                }

            }

            customLoadingDialog.dismissAllowingStateLoss()

        })

    }

}
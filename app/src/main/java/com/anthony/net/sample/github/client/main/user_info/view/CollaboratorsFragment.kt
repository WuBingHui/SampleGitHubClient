package com.anthony.net.sample.github.client.main.user_info.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.anthony.net.sample.github.client.base.BaseFragment
import com.anthony.net.sample.github.client.databinding.FragmentCollaboratorsBinding
import com.anthony.net.sample.github.client.main.user_info.adapter.CollaboratorItemCallback
import com.anthony.net.sample.github.client.main.user_info.adapter.CollaboratorsAdapter
import com.anthony.net.sample.github.client.main.user_info.viewmodel.CollaboratorsViewModel
import com.anthony.net.sample.github.client.network.Resource
import org.koin.android.ext.android.inject

class CollaboratorsFragment : BaseFragment() {

    private lateinit var viewBinding: FragmentCollaboratorsBinding

    private val collaboratorsViewModel: CollaboratorsViewModel by inject()

    private var collaboratorsAdapter: CollaboratorsAdapter? = null

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

        customLoadingDialog.show(activity?.supportFragmentManager?:childFragmentManager, customLoadingDialog.tag)

        val userName = arguments?.getString(USER_NAME) ?: ""

        val repoName = arguments?.getString(REPO_NAME) ?: ""

        collaboratorsViewModel.getCollaborators(userName, repoName)

    }

    private fun initView() {

        collaboratorsAdapter = CollaboratorsAdapter(CollaboratorItemCallback())

        val linearLayoutManager = LinearLayoutManager(context)

        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL

        viewBinding.collaboratorsRecyclerView.layoutManager = linearLayoutManager

        viewBinding.collaboratorsRecyclerView.adapter = collaboratorsAdapter

    }

    private fun initViewModel() {

        collaboratorsViewModel.onCollaborators.observe(viewLifecycleOwner) { resource ->

            when (resource) {

                is Resource.Success -> collaboratorsAdapter?.submitList(resource.data)

                is Resource.Error -> Toast.makeText(
                    context,
                    resource.errorMessage,
                    Toast.LENGTH_SHORT
                ).show()

            }

            customLoadingDialog.dismissAllowingStateLoss()

        }

    }

}
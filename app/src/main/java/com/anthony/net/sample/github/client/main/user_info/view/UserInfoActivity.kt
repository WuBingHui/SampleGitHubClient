package com.anthony.net.sample.github.client.main.user_info.view

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.anthony.net.sample.github.client.base.BaseActivity
import com.anthony.net.sample.github.client.databinding.ActivityUserInfoBinding
import com.anthony.net.sample.github.client.dto.response.Repository
import com.anthony.net.sample.github.client.main.user_info.adapter.RepositoriesAdapter
import com.anthony.net.sample.github.client.main.user_info.adapter.RepositoryItemCallback

class UserInfoActivity : BaseActivity() {

    companion object {

        const val BUNDLE_EXTRA = "BundleExtra"

        const val REPOSITORIES = "Repository"

        const val USER_NAME = "UserName"

    }

    private lateinit var viewBinding: ActivityUserInfoBinding

    private var repositoriesAdapter: RepositoriesAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityUserInfoBinding.inflate(layoutInflater)

        setContentView(viewBinding.root)

        initView()

    }

    private fun initView() {

        val bundleExtra = intent.getBundleExtra(BUNDLE_EXTRA)

        val userName = bundleExtra?.getString(USER_NAME)

        viewBinding.userName.text = userName

        repositoriesAdapter = RepositoriesAdapter(RepositoryItemCallback())

        val linearLayoutManager = LinearLayoutManager(this)

        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL

        viewBinding.repositoriesRecyclerView.layoutManager = linearLayoutManager

        viewBinding.repositoriesRecyclerView.adapter = repositoriesAdapter

        val repositories = bundleExtra?.getSerializable(REPOSITORIES) as? List<Repository>

        repositories?.let {
            repositoriesAdapter?.submitList(repositories)
        }

    }

}
package com.anthony.net.sample.github.client.main.user_info.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.anthony.net.sample.github.client.base.BaseActivity
import com.anthony.net.sample.github.client.databinding.ActivityUserInfoBinding
import com.anthony.net.sample.github.client.dto.response.Repository
import com.anthony.net.sample.github.client.main.login.viewmodel.LoginViewModel
import com.anthony.net.sample.github.client.main.user_info.adapter.RepositoriesAdapter
import com.anthony.net.sample.github.client.main.user_info.adapter.RepositoryItemCallback
import com.anthony.net.sample.github.client.main.user_info.viewmodel.UserInfoViewModel
import com.anthony.net.sample.github.client.network.Status
import org.koin.android.ext.android.inject

class UserInfoActivity : BaseActivity(), RepositoriesAdapter.OnRepositoryItemClick {

    companion object {

        const val LOGIN_NAME = "LoginName"

    }

    private lateinit var viewBinding: ActivityUserInfoBinding

    private var repositoriesAdapter: RepositoriesAdapter? = null

    private val userInfoViewModel: UserInfoViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityUserInfoBinding.inflate(layoutInflater)

        setContentView(viewBinding.root)

        initView()

        initViewModel()

    }


    private fun initView() {

        val loginName = intent.getStringExtra(LOGIN_NAME) ?: ""

        viewBinding.userName.text = loginName

        repositoriesAdapter = RepositoriesAdapter(RepositoryItemCallback(), this)

        val linearLayoutManager = LinearLayoutManager(this)

        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL

        viewBinding.repositoriesRecyclerView.layoutManager = linearLayoutManager

        viewBinding.repositoriesRecyclerView.adapter = repositoriesAdapter

        customLoadingDialog.show(supportFragmentManager, customLoadingDialog.tag)

        userInfoViewModel.getRepositories(loginName)

    }

    private fun initViewModel() {

        userInfoViewModel.onRepositories.observe(this, Observer { dto ->

            when (dto.status) {

                Status.SUCCESS -> {

                    dto.data?.let {

                        repositoriesAdapter?.submitList(it)

                    }

                }

                Status.FAILED -> {

                    Toast.makeText(this@UserInfoActivity, dto.message, Toast.LENGTH_LONG).show()

                }
            }

            customLoadingDialog.dismissAllowingStateLoss()

        })

    }

    override fun onRepositoryItemClick(position: Int) {

        val intent = Intent()

        val bundle = Bundle()

        bundle.putSerializable(
            RepositoryActivity.REPOSITORY,
            repositoriesAdapter?.currentList?.get(position)
        )

        intent.putExtra(
            RepositoryActivity.BUNDLE,
            bundle
        )

        intent.setClass(this, RepositoryActivity::class.java)

        startActivity(intent)

    }

}
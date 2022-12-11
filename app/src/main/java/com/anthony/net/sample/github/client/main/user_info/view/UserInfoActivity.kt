package com.anthony.net.sample.github.client.main.user_info.view

import android.os.Bundle
import com.anthony.net.sample.github.client.base.BaseActivity
import com.anthony.net.sample.github.client.databinding.ActivityUserInfoBinding

class UserInfoActivity : BaseActivity() {

    companion object {

        const val BUNDLE_EXTRA = "BundleExtra"

        const val REPOSITORIES = "Repository"

        const val USER_NAME = "UserName"

    }

    private lateinit var viewBinding: ActivityUserInfoBinding

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

    }

}
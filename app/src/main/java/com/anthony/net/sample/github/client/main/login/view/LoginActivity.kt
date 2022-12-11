package com.anthony.net.sample.github.client.main.login.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import com.anthony.net.sample.github.client.R
import com.anthony.net.sample.github.client.base.BaseActivity
import com.anthony.net.sample.github.client.databinding.ActivityLoginBinding
import com.anthony.net.sample.github.client.main.login.viewmodel.LoginViewModel
import com.anthony.net.sample.github.client.main.user_info.view.UserInfoActivity
import com.anthony.net.sample.github.client.network.Status
import org.koin.android.ext.android.inject
import java.io.Serializable

class LoginActivity : BaseActivity() {

    private lateinit var viewBinding: ActivityLoginBinding

    private val loginViewModel: LoginViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(viewBinding.root)

        initView()

        initViewModel()

    }

    private fun initView() {

        viewBinding.startedBtn.setOnClickListener {

            val userName = viewBinding.accountEditText.text.toString()

            if (userName.isEmpty()) {

                Toast.makeText(this, getString(R.string.account_hint), Toast.LENGTH_SHORT).show()

                return@setOnClickListener

            }

            customLoadingDialog.show(supportFragmentManager, customLoadingDialog.tag)

            loginViewModel.getUserRepositories(userName)

        }

    }

    private fun initViewModel() {

        loginViewModel.onUserRepositories.observe(this, Observer { dto ->

            when (dto.status) {

                Status.SUCCESS -> {

                    dto.data?.let { repositories ->

                        val intent = Intent()

                        val bundle = Bundle()

                        bundle.putString(
                            UserInfoActivity.USER_NAME,
                            viewBinding.accountEditText.text.toString()
                        )

                        bundle.putSerializable(
                            UserInfoActivity.REPOSITORIES,
                            repositories as? Serializable
                        )

                        intent.putExtra(UserInfoActivity.BUNDLE_EXTRA, bundle)

                        intent.setClass(this, UserInfoActivity::class.java)

                        startActivity(intent)

                        finish()

                    }

                }

                Status.FAILED -> {

                    Toast.makeText(this@LoginActivity, dto.message, Toast.LENGTH_LONG).show()

                }
            }

            customLoadingDialog.dismissAllowingStateLoss()

        })

    }


}
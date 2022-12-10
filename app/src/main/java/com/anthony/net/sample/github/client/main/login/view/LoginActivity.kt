package com.anthony.net.sample.github.client.main.login.view

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import com.anthony.net.sample.github.client.R
import com.anthony.net.sample.github.client.base.BaseActivity
import com.anthony.net.sample.github.client.databinding.ActivityLoginBinding
import com.anthony.net.sample.github.client.main.login.viewmodel.LoginViewModel
import com.anthony.net.sample.github.client.network.Status
import org.koin.android.ext.android.inject

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

                    Toast.makeText(this@LoginActivity, "Success", Toast.LENGTH_LONG).show()

                }

                Status.FAILED -> {

                    Toast.makeText(this@LoginActivity, dto.message, Toast.LENGTH_LONG).show()

                }
            }

            customLoadingDialog.dismissAllowingStateLoss()

        })

    }


}
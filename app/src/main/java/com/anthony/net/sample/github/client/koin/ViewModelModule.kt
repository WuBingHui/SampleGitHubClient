package com.anthony.net.sample.github.client.koin


import com.anthony.net.sample.github.client.main.login.viewmodel.LoginViewModel
import com.anthony.net.sample.github.client.main.user_info.viewmodel.CollaboratorsViewModel
import com.anthony.net.sample.github.client.main.user_info.viewmodel.CommitsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { LoginViewModel(get()) }

    viewModel { CommitsViewModel(get()) }

    viewModel { CollaboratorsViewModel(get()) }


}
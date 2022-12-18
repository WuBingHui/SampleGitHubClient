package com.anthony.net.sample.github.client.koin


import com.anthony.net.sample.github.client.main.login.viewmodel.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { LoginViewModel(get()) }


}
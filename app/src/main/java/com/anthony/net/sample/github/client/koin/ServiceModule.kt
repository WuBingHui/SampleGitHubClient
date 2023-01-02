package com.anthony.net.sample.github.client.koin


import com.anthony.net.sample.github.client.network.RetrofitBuilder.createService
import com.anthony.net.sample.github.client.service.login.LoginService
import com.anthony.net.sample.github.client.service.user_info.CollaboratorsService
import com.anthony.net.sample.github.client.service.user_info.CommitsService
import com.anthony.net.sample.github.client.service.user_info.UserInfoService
import org.koin.dsl.module

val serviceModule = module {

    factory<LoginService> { createService() }

    factory<CommitsService> { createService() }

    factory<CollaboratorsService> { createService() }

    factory<UserInfoService> { createService() }

}
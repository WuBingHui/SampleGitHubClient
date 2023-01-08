package com.anthony.net.sample.github.client.koin


import com.anthony.net.sample.github.client.repository.login.LoginRepository
import com.anthony.net.sample.github.client.repository.user_info.CollaboratorsRepository
import com.anthony.net.sample.github.client.repository.user_info.CommitsRepository
import com.anthony.net.sample.github.client.repository.user_info.UserInfoRepository
import org.koin.dsl.module

val repositoryModule = module {

    factory { LoginRepository(get()) }

    factory { CommitsRepository(get()) }

    factory { CollaboratorsRepository(get()) }

    factory { UserInfoRepository(get()) }

}
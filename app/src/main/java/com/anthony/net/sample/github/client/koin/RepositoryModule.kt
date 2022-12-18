package com.anthony.net.sample.github.client.koin


import com.anthony.net.sample.github.client.model.login.repository.LoginRepository
import com.anthony.net.sample.github.client.model.user_info.repository.CollaboratorsRepository
import com.anthony.net.sample.github.client.model.user_info.repository.CommitsRepository
import org.koin.dsl.module

val repositoryModule = module {

    factory { LoginRepository(get()) }

    factory { CommitsRepository(get()) }

    factory { CollaboratorsRepository(get()) }

}
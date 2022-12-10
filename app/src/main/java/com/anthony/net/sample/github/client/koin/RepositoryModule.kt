package com.anthony.net.sample.github.client.koin


import com.anthony.net.sample.github.client.model.login.repository.LoginRepository
import org.koin.dsl.module

val repositoryModule = module {

    factory { LoginRepository(get()) }

}
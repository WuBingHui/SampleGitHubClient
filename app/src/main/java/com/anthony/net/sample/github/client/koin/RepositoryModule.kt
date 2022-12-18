package com.anthony.net.sample.github.client.koin


import com.anthony.net.sample.github.client.model.login.repository.LoginRepository
import com.anthony.net.sample.github.client.model.search.repository.SearchRepository
import org.koin.dsl.module

val repositoryModule = module {

    factory { LoginRepository(get()) }

    factory { SearchRepository(get()) }

}
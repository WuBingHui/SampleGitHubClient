package com.anthony.net.sample.github.client.koin



import com.anthony.net.sample.github.client.model.repository.GithubClientRepository
import org.koin.dsl.module

val repositoryModule = module {

    factory { GithubClientRepository(get()) }

}
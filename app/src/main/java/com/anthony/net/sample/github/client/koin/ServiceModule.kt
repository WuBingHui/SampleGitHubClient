package com.anthony.net.sample.github.client.koin



import com.anthony.net.sample.github.client.network.RetrofitBuilder.createService
import com.anthony.net.sample.github.client.service.GithubClientService
import org.koin.dsl.module

val serviceModule = module {

    factory<GithubClientService> { createService() }

}
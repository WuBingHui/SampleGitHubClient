package com.anthony.net.sample.github.client.koin



import com.anthony.net.sample.github.client.network.RetrofitBuilder.createService
import com.anthony.net.sample.github.client.service.login.LoginService
import org.koin.dsl.module

val serviceModule = module {

    factory<LoginService> { createService() }

}
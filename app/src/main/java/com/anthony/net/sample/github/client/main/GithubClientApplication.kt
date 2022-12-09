package com.anthony.net.sample.github.client.main

import androidx.multidex.MultiDexApplication
import com.anthony.net.sample.github.client.koin.repositoryModule
import com.anthony.net.sample.github.client.koin.serviceModule
import com.anthony.net.sample.github.client.koin.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class GithubClientApplication : MultiDexApplication() {

    companion object {

        lateinit var context: GithubClientApplication
            private set

    }

    override fun onCreate() {
        super.onCreate()

        context = this

        startKoin {

            androidContext(this@GithubClientApplication)

            modules(listOf(viewModelModule, serviceModule, repositoryModule))

        }

    }

}
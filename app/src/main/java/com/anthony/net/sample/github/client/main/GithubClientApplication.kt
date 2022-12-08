package com.anthony.net.sample.github.client.main

import androidx.multidex.MultiDexApplication
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

//            modules(listOf(viewModelModule, serviceModule, repositoryModule))

        }

    }

}
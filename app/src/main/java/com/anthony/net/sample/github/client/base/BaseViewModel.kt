package com.anthony.net.sample.github.client.base

import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {

    fun cleared() {

        this.onCleared()

    }

}
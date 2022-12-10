package com.aotter.aotter_suprone_android.base

import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {

    fun cleared() {

        this.onCleared()

    }

}
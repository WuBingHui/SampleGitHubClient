package com.anthony.net.sample.github.client.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.anthony.net.sample.github.client.widget.CustomLoadingDialog


open class BaseActivity : AppCompatActivity() {

    val customLoadingDialog = CustomLoadingDialog.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }


}
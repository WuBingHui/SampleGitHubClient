package com.anthony.net.sample.github.client.base

import androidx.appcompat.app.AppCompatActivity
import com.anthony.net.sample.github.client.widget.CustomLoadingDialog


open class BaseActivity : AppCompatActivity() {

    val customLoadingDialog = CustomLoadingDialog.newInstance()


}
package com.anthony.net.sample.github.client.base

import androidx.fragment.app.Fragment
import com.anthony.net.sample.github.client.widget.CustomLoadingDialog

open class BaseFragment : Fragment() {

    val customLoadingDialog = CustomLoadingDialog.newInstance()

}
package com.anthony.net.sample.github.client.base

import androidx.fragment.app.DialogFragment
import com.anthony.net.sample.github.client.widget.CustomLoadingDialog


open class BaseDialogFragment : DialogFragment() {

    val customLoadingDialog = CustomLoadingDialog.newInstance()


}